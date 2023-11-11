// package th.mfu.controller;

// import java.sql.Date;
// import java.text.SimpleDateFormat;
// import java.util.HashMap;
// import java.util.Locale;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.propertyeditors.CustomDateEditor;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.WebDataBinder;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.InitBinder;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import th.mfu.domain.WashingMachine;
// import th.mfu.repository.WashingMachineRepository;

// @Controller
// public class WashingMachineController {
//     @Autowired
//     WashingMachineRepository washRepo ;

//     @InitBinder
//     public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
//         final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
//         binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//     }

//     @GetMapping("/WashingMachines")
//     public String listWashingMatchine(Model model) {
//         model.addAttribute("washingMachines", washRepo.findAll());
//         return "list-WashingMachine";
//     }

//     @GetMapping("/add-WashingMachine")
//     public String addWashingMachineForm(Model model) {
//         model.addAttribute("washingMachine", new WashingMachine());
//         return "add-WashingMachine-form";
//     }

//     @PostMapping("/WashingMachines_save")
//     public String saveWashingMacine(@ModelAttribute WashingMachine newwashingMachine) {
//         washRepo.save(newwashingMachine);
//         return "redirect:/WashingMachines";
//     }

//     @GetMapping("/delete-WashingMachine/{id}")
//     public String deleteWashingMachine(@PathVariable Long id) {
//         washRepo.deleteById(id);;
//         return "redirect:/WashingMachines";
//     }

//     @GetMapping("/delete-WashingMachine")
//     public String removeAllWashingMachines(Model model) {
//        washRepo.deleteAll();
//         return "redirect:/WashingMachines";
//     }
// }
