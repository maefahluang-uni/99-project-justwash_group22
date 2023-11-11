package th.mfu.controller;

//seat=queue
import java.sql.Date;
import java.text.SimpleDateFormat;
/*import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map; */
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import th.mfu.domain.Reservation;
import th.mfu.domain.User;
import th.mfu.domain.WashingMachine;
import th.mfu.repository.ReservationRepository;
import th.mfu.repository.UserRepository;
import th.mfu.repository.WashingMachineRepository;

@Controller
public class UserController{

    @Autowired
    UserRepository userRepo;

    @Autowired
    WashingMachineRepository washingMachinesRepo;

    @Autowired
    ReservationRepository reserveRepo;

    @GetMapping("/WashingMachines")
    public String listWashingMatchine(Model model) {
        model.addAttribute("washingMachines", washingMachinesRepo.findAll());
        return "list-WashingMachine";
    }

    @GetMapping("/add-WashingMachine")
    public String addWashingMachineForm(Model model) {
        model.addAttribute("washingMachine", new WashingMachine());
        return "add-WashingMachine-form";
    }

    @PostMapping("/WashingMachines")
    public String saveWashingMacine(@ModelAttribute WashingMachine washingMachine) {
        washingMachinesRepo.save(washingMachine);
        return "redirect:/WashingMachines";
    }

    @Transactional
    @GetMapping("/delete-WashingMachine/{id}")
    public String deleteWashingMachine(@PathVariable Long id) {
        washingMachinesRepo.deleteById(id);;
        return "redirect:/WashingMachines";
    }

    @GetMapping("/delete-WashingMachine")
    public String removeAllWashingMachines(Model model) {
       washingMachinesRepo.deleteAll();
        return "redirect:/WashingMachines";
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

 ///////////////
    @GetMapping("/user_book")
    public String ShowUserBook(Model model) {
        model.addAttribute("washingMachines", washingMachinesRepo.findAll());
        return "for-user";
    }

    @GetMapping("/book")
    public String book(Model model) {
        // TODO: list all reservations
        model.addAttribute("reservation", reserveRepo.findAll());
        // TODO: return a template to list reservations
        return "book";
    }

    // TODO: add proper annotation for GET method
    @GetMapping("/book/justwash/{washingMachineId}")
    public String reserveWashForm(@PathVariable Long washingMachineId, Model model) {
        // TODO: add concert to model
        model.addAttribute("washingMachines", washingMachinesRepo.findById(washingMachineId).get());
        // TODO: add empty reservation to model
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        // TODO: find available seats (booked=false) by given concert's id to the model
        List<WashingMachine> machines = washingMachinesRepo.findByBookedFalseAndId(washingMachineId);
        model.addAttribute("washingMachines", machines);
        return "reserve-machine";
    }

    @Transactional
    // TODO: add proper annotation for POST method
    @PostMapping("/book/justwash/{washingMachineId}")
    public String reserveWash(@ModelAttribute Reservation reservation, @PathVariable Long washId, Model model) {
        // TODO: find selectd seat by id
        WashingMachine washingMachine = washingMachinesRepo.findById(reservation.getUser().getId()).get();
        // TODO: set booked to true
        washingMachine.setBooked(true);
        // TODO: save seat
        washingMachinesRepo.save(washingMachine);
        // TODO: save reservation using reservationRepo
        reserveRepo.save(reservation);
        return "redirect:/book";
    }
    
}



