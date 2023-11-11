package th.mfu.controller;

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
    WashingMachineRepository washRepo;
    @Autowired
    ReservationRepository reservRepo;
@InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/user_book")
    public String ShowUserBook(Model model) {
        model.addAttribute("washingMachines", washRepo.findAll());
        return "for-user";
    }

    // @GetMapping("/book")
    // public String book(Model model) {
    //     // TODO: list all reservations
    //     model.addAttribute("reservation", reservRepo.findAll());
    //     // TODO: return a template to list reservations
    //     return "book";
    // }

    // // TODO: add proper annotation for GET method
    // @GetMapping("/book/justwash/{washingMachineId}")
    // public String reserveWashForm(@PathVariable Long washId, Model model) {
    //     // TODO: add concert to model
    //     model.addAttribute("washingMachines", washRepo.findById(washId).get());
    //     // TODO: add empty reservation to model
    //     Reservation reservation = new Reservation();
    //     model.addAttribute("reservation", reservation);
    //     // TODO: find available seats (booked=false) by given concert's id to the model
    //     List<User> users = userRepo.findByBookedFalseAndwashId(washId);
    //     model.addAttribute("users", users);
    //     return "reserve-user";
    // }

    // @Transactional
    // // TODO: add proper annotation for POST method
    // @PostMapping("/book/justwash/{washingMachineId}")
    // public String reserveSeat(@ModelAttribute Reservation reservation, @PathVariable Long washId, Model model) {
    //     // TODO: find selectd seat by id
    //     User user = userRepo.findById(reservation.getUser().getId()).get();
    //     // TODO: set booked to true
    //     user.setBooked(true);
    //     // TODO: save seat
    //     userRepo.save(user);
    //     // TODO: save reservation using reservationRepo
    //     reservRepo.save(reservation);
    //     return "redirect:/book";
    // }
    
}



