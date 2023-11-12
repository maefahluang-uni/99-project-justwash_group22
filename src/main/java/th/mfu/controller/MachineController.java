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

import th.mfu.domain.Machine;
import th.mfu.domain.Reservation;
import th.mfu.domain.Queue;
import th.mfu.repository.MachineRepository;
import th.mfu.repository.QueueRepository;
import th.mfu.repository.ReservationRepository;
import th.mfu.repository.MachineRepository;

@Controller
public class MachineController {
    @Autowired
    MachineRepository machineRepo;

    @Autowired
    QueueRepository queueRepo;

    @Autowired
    ReservationRepository reservationRepo;

    //TODO: add proper annotation for GET method
    @GetMapping("/book")
    public String book(Model model) {
        // TODO: list all concerts
        model.addAttribute("machines", machineRepo.findAll());
        // TODO: return a template to list concerts
        return "book";
    }

    //TODO: add proper annotation for GET method
    @GetMapping("/book/machines/{machineId}")
    public String reserveQueueForm(@PathVariable Long machineId, Model model) {
        // TODO: add concert to model
        model.addAttribute("machines", machineRepo.findById(machineId).get());
        // TODO: add empty reservation to model
        model.addAttribute("reservation", new Reservation());
        // TODO: find available seats (booked=false) by given concert's id to the model
        model.addAttribute("queues", queueRepo.findByBookedFalseAndMachineId(machineId));
        return "reserve-queue";
    }

    @Transactional
    //TODO: add proper annotation for POST method
    @PostMapping("/book/machines/{machineId}")
    public String reserveQueue(@ModelAttribute Reservation reservation, @PathVariable Long machinetId, Model model) {
        // TODO: find selectd seat by id
        Queue queue = reservation.getQueue();
        //TODO: set booked to true
        queue.setBooked(true);
        //TODO: save seat
        queueRepo.save(queue);
        // TODO: save reservation using reservationRepo
        reservationRepo.save(reservation);
        return "redirect:/book";
    }

    /*************************************/
    /* No Modification beyond this line */
    /*************************************/

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/machines")
    public String listMachines(Model model) {
        model.addAttribute("machines", machineRepo.findAll());
        return "list-machine";
    }

    @GetMapping("/add-machines")
    public String addMachineForm(Model model) {
        model.addAttribute("machines", new Machine());
        return "add-machine-form";
    }

    @PostMapping("/save-machines")
    public String saveMachine(@ModelAttribute Machine newmachine) {
        machineRepo.save(newmachine);
        return "redirect:/machines";
    }

    @Transactional
    @GetMapping("/delete-machine/{id}")
    public String deleteMachine(@PathVariable long id) {
        queueRepo.deleteByMachineId(id);
        machineRepo.deleteById(id);
        return "redirect:/machines";
    }

    @GetMapping("/machines/{id}/queues")
    public String showAddSeatForm(Model model, @PathVariable Long id) {
        model.addAttribute("queues", queueRepo.findByMachineId(id));

        Machine machine = machineRepo.findById(id).get();
        Queue queue = new Queue();
        queue.setMachine(machine);
        model.addAttribute("newqueue", queue);
        return "queue-mgmt";
    }

    @PostMapping("/machines/{id}/queues")
    public String saveQueue(@ModelAttribute Queue newqueue, @PathVariable Long id) {
        Machine machine = machineRepo.findById(id).get();
        newqueue.setMachine(machine);
        queueRepo.save(newqueue);
        return "redirect:/machines/" + id + "/queues";
    }

   

}
