package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Changed from @RestController
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to My Beautiful Page");
        model.addAttribute("message", "🌟 Hello, Visitor! Enjoy Your Stay! 🚀");
        return "home"; // Refers to home.html in templates folder
    }
}
