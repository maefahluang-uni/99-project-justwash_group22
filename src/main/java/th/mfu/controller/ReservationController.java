package th.mfu.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.Reservation;

@Controller
public class ReservationController {
    private HashMap<Integer, Reservation> reservations = new HashMap<Integer, Reservation>();
    private int nextId = 1;

    private int date;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/Reservations")
    public String listReservation(Model model) {
        model.addAttribute("Reservations", reservations.values());
        return "list-Reservation";
    }

    @GetMapping("/add-Reservation")
    public String addReservationForm(Model model) {
        model.addAttribute("Reservation", new Reservation());
        return "add-Reservation-form";
    }

    @PostMapping("/Reservations")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservation.setId(nextId);
        reservations.put(nextId, reservation);
        nextId++;
        return "redirect:/Reservations";
    }

    @GetMapping("/delete-Reservation/{id}")
    public String deleteReservation(@PathVariable int id) {
        reservations.remove(id);
        return "redirect:/Reservations";
    }

    @GetMapping("/delete-Reservation")
    public String removeAllReservations(Model model) {
        reservations.clear();
        nextId = 1;
        return "redirect:/Reservations";
    }
}
