package com.wipro.cashback.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.cashback.model.Customer;
import com.wipro.cashback.service.CashbackService;
import com.wipro.cashback.service.CashbackService.CashbackResult;

@Controller
public class CashbackController {

    private final CashbackService service;

    public CashbackController(CashbackService service) {
        this.service = service;
    }

    @GetMapping("/offer")
    public String offer(HttpSession session, Model model) {
        String customerId = (String) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/";
        }

        Customer customer = service.getCustomer(customerId);
        if (customer == null) {
            session.invalidate();
            return "redirect:/";
        }

        model.addAttribute("customer", customer);
        return "offer";
    }

    @PostMapping("/claim")
    public String claim(@RequestParam(required = false) String couponCode,
                        HttpSession session,
                        Model model) {

        String customerId = (String) session.getAttribute("customerId");
        if (customerId == null) {
            return "redirect:/";
        }

        if (couponCode == null || couponCode.isBlank()) {
            Customer customer = service.getCustomer(customerId);
            model.addAttribute("customer", customer);
            model.addAttribute("error", "Coupon Code is mandatory.");
            return "offer";
        }

        CashbackResult result = service.claimCashback(customerId, couponCode.trim().toUpperCase());

        if (!result.isSuccess()) {
            Customer customer = service.getCustomer(customerId);
            model.addAttribute("customer", customer);
            model.addAttribute("error", result.getMessage());
            return "offer";
        }

        model.addAttribute("percentage", result.getPercentage());
        model.addAttribute("cashback", result.getCashback());
        model.addAttribute("updatedBalance", result.getUpdatedBalance());
        return "success";
    }
}
