package th.mfu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import th.mfu.domain.WashingMachine;
import th.mfu.domain.Reservation;
import th.mfu.domain.User;
import th.mfu.repository.ReservationRepository;
import th.mfu.repository.UserRepository;
import th.mfu.repository.WashingMachineRepository;

@Controller
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    WashingMachineRepository washingmachineRepo;

    @GetMapping("/book")
    public String book(Model model) {
        // list all reservations
        model.addAttribute("reservations", reservationRepo.findAll());
        // return a template to list reservations
        return "book";
    }

    @GetMapping("/book/reservations/{reservationId}")
    public String reserveUserForm(@PathVariable Integer reservationId, Model model) {
        model.addAttribute("reservation", reservationRepo.findById(reservationId).get());
        WashingMachine washingMachine = new WashingMachine();
        model.addAttribute("washingmachine", washingMachine);
        List<org.apache.tomcat.jni.User> users = userRepo.findByBookedFalseAndReservationId(reservationId);
        model.addAttribute("users", users);
        return "reserve-user";
    }

    @Transactional
    @PostMapping("/book/reservations/{reservationId}")
    public String reserveUser(@ModelAttribute WashingMachine washingMachine, @PathVariable Integer reservationId,
            Model model) {
        User user = userRepo.findById(washingMachine.getReservation().getId()).get();
        user.setBooked(true);
        userRepo.save(user);
        washingmachineRepo.save(washingMachine);
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
        reservationRepo.deleteByReservationId(id);
        reservationRepo.deleteById(id);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/{id}/users")
    public String showAddUserForm(Model model, @PathVariable Integer id) {
        model.addAttribute("users", userRepo.findByReservationId(id));

        Reservation reservation = reservationRepo.findById(id).get();
        User user = new User();
        user.setReservation(reservation);
        model.addAttribute("newuser", user);
        return "user-mgmt";
    }

    @PostMapping("/reservations/{id}/users")
    public String saveUser(@ModelAttribute User newuser, @PathVariable Integer id) {
        Reservation reservation = reservationRepo.findById(id).get();
        newuser.setReservation(reservation);
        userRepo.save(newuser);
        return "redirect:/reservations/" + id + "/users";
    }

}