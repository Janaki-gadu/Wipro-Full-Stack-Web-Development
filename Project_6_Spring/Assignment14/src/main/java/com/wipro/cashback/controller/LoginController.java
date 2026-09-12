package com.wipro.cashback.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.cashback.model.Customer;
import com.wipro.cashback.service.CashbackService;

@Controller
public class LoginController {

    private final CashbackService service;

    public LoginController(CashbackService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(required = false) String customerId,
                        @RequestParam(required = false) String password,
                        HttpSession session,
                        Model model) {

        if (customerId == null || customerId.isBlank() ||
            password == null || password.isBlank()) {
            model.addAttribute("error", "Customer ID and Password are mandatory.");
            return "login";
        }

        Customer customer = service.authenticate(customerId.trim(), password);
        if (customer == null) {
            model.addAttribute("error", "Invalid Customer ID or Password.");
            return "login";
        }

        session.setAttribute("customerId", customer.getCustomerId());
        return "redirect:/offer";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
