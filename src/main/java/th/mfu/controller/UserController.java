package th.mfu.controller;

/*import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map; */
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import th.mfu.domain.User;
import th.mfu.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepo;

    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        if (User.containsKey(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        } 

        userRepo.put(user.getUsername(), user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/users")
    public Collection<org.apache.tomcat.jni.User> list() {
        return userRepo.values();
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return userRepo.get(username);
    }

    // Show the Register Form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Log In
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Log Out
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/logout")
    public String performLogout(HttpServletRequest request) {
        request.getSession().invalidate(); // Invalidate the user's session
        return "redirect:/login"; // Redirect to the login page after logging out
    }

    // View User Profile
    @GetMapping("/profile/{username}")
    public String viewUserProfile(@PathVariable String username, Model model) {
        User user = userRepo.get(username);
        model.addAttribute("user", user);
        return "profile";
    }

    // Delete User's Account
    @PostMapping("/users/{username}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        if (userRepo.containsKey(username)) {
            userRepo.remove(username);
            return ResponseEntity.ok("Account deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    /*@GetMapping("/users")
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
    } */
}

