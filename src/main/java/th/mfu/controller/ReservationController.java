package th.mfu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.User; //reservation
import th.mfu.domain.Reservation; //concert
import th.mfu.domain.WashingMachine; //seat
import th.mfu.repository.ReservationRepository;
import th.mfu.repository.UserRepository;
import th.mfu.repository.WashingMachineRepository;

@Controller
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepo;

    @Autowired
    WashingMachineRepository washingMachineRepo;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/book")
    public String book(Model model) {
        // TODO: list all reservations
        model.addAttribute("reservations", reservationRepo.findAll());
        // TODO: return a template to list reservations
        return "book";
    }

    @GetMapping("/book/reservations/{reservationId}")
    public String reserveWashingMachineForm(@PathVariable Integer reservationId, Model model) {
        model.addAttribute("reservation", reservationRepo.findById(reservationId).get());
        User user = new User();
        model.addAttribute("user", user);
        List<WashingMachine> washingMachines = washingMachineRepo.findByBookedFalseAndReservationId(reservationId);
        model.addAttribute("washingMachines", washingMachines);
        return "reserve-washingMachine";
    }

    @Transactional
    @PostMapping("/book/reservations/{reservationId}")
    public String reserveWashingMachine(@ModelAttribute User user, @PathVariable Integer reservationId, Model model) {
        WashingMachine washingMachine = washingMachineRepo.findById(user.getWashingMachine().getId()).get();
        washingMachine.setBooked(true);
        washingMachineRepo.save(washingMachine);
        userRepo.save(user);
        return "redirect:/book";
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationRepo.findAll());
        return "list-reservation";
    }

    @GetMapping("/add-reservation")
    public String addAReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "add-reservation-form";
    }

    @PostMapping("/reservations")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservationRepo.save(reservation);
        return "redirect:/reservations";
    }

    @Transactional
    @GetMapping("/delete-reservation/{id}")
    public String deleteReservation(@PathVariable Integer id) {
        washingMachineRepo.deleteByReservationId(id);
        reservationRepo.deleteById(id);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/{id}/washingMachines")
    public String showAddWashingMachineForm(Model model, @PathVariable Integer id) {
        model.addAttribute("washingMachines", washingMachineRepo.findByReservationId(id));

        Reservation reservation = reservationRepo.findById(id).get();
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.setReservation(reservation);
        model.addAttribute("newwashingMachine", washingMachine);
        return "washingMachine-mgmt";
    }

    @PostMapping("/reservations/{id}/washingMachines")
    public String saveWashingMachine(@ModelAttribute WashingMachine newwashingMachine, @PathVariable Integer id) {
        Reservation reservation = reservationRepo.findById(id).get();
        newwashingMachine.setReservation(reservation);
        washingMachineRepo.save(newwashingMachine);
        return "redirect:/reservations/" + id + "/washingMachines";
    }

}