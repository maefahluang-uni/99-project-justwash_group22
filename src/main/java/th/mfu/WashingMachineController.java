package th.mfu;

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

import th.mfu.domain.WashingMachine;

@Controller
public class WashingMachineController {
    private HashMap<Integer, WashingMachine> washingMachines = new HashMap<Integer, WashingMachine>();
    private int nextId = 1;

    private int date;
    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping ("/WashingMachines")
    public String listWashingMatchine(Model model) {
        model.addAttribute("washingMachines", washingMachines.values());
        return "list-WashingMachine";
    }

    @GetMapping ("/add-WashingMachine")
    public String addWashingMachineForm(Model model) {
        model.addAttribute("washingMachine", new WashingMachine());
        return "add-WashingMachine-form";
    }

    @PostMapping ("/WashingMachines")
    public String saveWashingMacine(@ModelAttribute WashingMachine washingMachine) {
        washingMachine.setId(nextId);
        washingMachines.put(nextId, washingMachine);
        nextId++;
        return "redirect:/WashingMachines";
    }

    @GetMapping ("/delete-WashingMachine/{id}")
    public String deleteWashingMachine(@PathVariable int id) {
        washingMachines.remove(id);
        return "redirect:/WashingMachines";
    }

    @GetMapping ("/delete-WashingMachine")
    public String removeAllWashingMachines(Model model) {
        washingMachines.clear();
        nextId = 1;
        return "redirect:/WashingMachinse";
    }
}
