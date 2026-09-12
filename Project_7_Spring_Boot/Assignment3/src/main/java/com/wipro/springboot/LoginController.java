package com.wipro.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if ("Wipro".equals(username) && "123".equals(password)) {
            model.addAttribute("username", username);
            return "success";
        }
        model.addAttribute("message", "Invalid username or password.");
        return "failure";
    }
}
