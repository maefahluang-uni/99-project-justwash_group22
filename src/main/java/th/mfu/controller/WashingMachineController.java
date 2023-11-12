package th.mfu.controller;

/*  seat=queue
    washingmachine=concert
    performer=user
    reservation=reservation*/

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

//import javax.servlet.http.HttpServletRequest;
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
import th.mfu.repository.QueueRepository;
import th.mfu.repository.ReservationRepository;
import th.mfu.repository.WashingMachineRepository;
import th.mfu.domain.Reservation;
import th.mfu.domain.Queue;
// import th.mfu.repository.QueueRepository;
// import th.mfu.repository.ReservationRepository;
// import th.mfu.repository.WashingMachineRepository;

@Controller
public class WashingMachineController{
    @Autowired
    WashingMachineRepository washingMachineRepo;

    @Autowired
    QueueRepository queueRepo;

    @Autowired
    ReservationRepository reserveRepo;

    @GetMapping("/book")
    public String book(Model model) {
        // TODO: list all reservations
        model.addAttribute("washingMachines", washingMachineRepo.findAll());
        // TODO: return a template to list reservations
        return "book";
    }

    // TODO: add proper annotation for GET method
    @GetMapping("/book/washingMachines/{washingMachineId}")
    public String reserveQueueForm(@PathVariable Long washingMachineId, Model model) {
        // TODO: add concert to model
        model.addAttribute("washingMachine", washingMachineRepo.findById(washingMachineId).get());
        // TODO: add empty reservation to model
        model.addAttribute("reservation", new Reservation());
        // TODO: find available seats (booked=false) by given concert's id to the model
        model.addAttribute("queues", queueRepo.findByBookedFalseAndWashingMachineId(washingMachineId));
        return "reserve-queue";
    }

    @Transactional
    // TODO: add proper annotation for POST method
    @PostMapping("/book/washingMachines/{washingMachineId}")
    public String reserveQueue(@ModelAttribute Reservation reservation, @PathVariable Long washId, Model model) {
        // TODO: find selectd seat by id
        Queue queue = reservation.getQueue();
        // TODO: set booked to true
        queue.setBooked(true);
        // TODO: save seat
        queueRepo.save(queue);
        // TODO: save reservation using reservationRepo
        reserveRepo.save(reservation);
        return "redirect:/book";
    }

    /////////////////////////////////////////////////////

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/washingMachines")
    public String listWashingMatchines(Model model) {
        model.addAttribute("washingMachines", washingMachineRepo.findAll());
        return "list-washingMachine";
    }

    @GetMapping("/add-washingMachine")
    public String addWashingMachineForm(Model model) {
        model.addAttribute("washingMachine", new WashingMachine());
        return "add-washingMachine-form";
    }

    @PostMapping("/washingMachines")
    public String saveWashingMacine(@ModelAttribute WashingMachine washingMachine) {
        washingMachineRepo.save(washingMachine);
        return "redirect:/washingMachines";
    }

    @Transactional
    @GetMapping("/delete-washingMachine/{id}")
    public String deleteWashingMachine(@PathVariable Long id) {
        queueRepo.deleteByWashingMachineId(id);
        washingMachineRepo.deleteById(id);
        return "redirect:/WashingMachines";
    }

    //delete all washingMachine
    @GetMapping("/delete-WashingMachine")
    public String removeAllWashingMachines(Model model) {
       washingMachineRepo.deleteAll();
        return "redirect:/WashingMachines";
    }

    @GetMapping("/washingMachines/{id}/queues")
    public String showAddQueueForm(Model model, @PathVariable Long id) {
        model.addAttribute("queues", queueRepo.findByWashingMachineId(id));

        WashingMachine washingMachine = washingMachineRepo.findById(id).get();
        Queue queue = new Queue();
        queue.setWashingMachine(washingMachine);
        model.addAttribute("newqueue", queue);
        return "queue-mgmt";
    }

    @PostMapping("/washingMachines/{id}/queues")
    public String saveQueue(@ModelAttribute Queue newqueue, @PathVariable Long id) {
        WashingMachine washingMachine = washingMachineRepo.findById(id).get();
        newqueue.setWashingMachine(washingMachine);
        queueRepo.save(newqueue);
        return "redirect:/washingMachines/" + id + "/queues";
    }

 ///////////////

    // @GetMapping("/user_book")
    // public String ShowUserBook(Model model) {
    //     model.addAttribute("washingMachines", washingMachineRepo.findAll());
    //     return "for-user";
    // }

    
    
}



