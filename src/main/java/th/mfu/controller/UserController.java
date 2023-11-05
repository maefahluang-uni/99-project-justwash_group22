package th.mfu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import th.mfu.domain.User;

@Controller
public class UserController {
    private int nextUserId = 1;
    private HashMap<Integer, User> users = new HashMap<>();

    // Add InitBinder for date conversion
    @InitBinder
    public void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", users.values());
        return "list-users"; // Create a corresponding HTML template
    }

    @GetMapping("/add-user")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user-form"; // Create a corresponding HTML template
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute User user) {
        user.setId(nextUserId);
        users.put(nextUserId, user);
        nextUserId++;
        return "redirect:/users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id) {
        users.remove(id);
        return "redirect:/users";
    }

    @GetMapping("/delete-users")
    public String deleteAllUsers() {
        users.clear();
        nextUserId = 1;
        return "redirect:/users";
    }
}

