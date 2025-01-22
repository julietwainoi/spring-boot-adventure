package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AnotherController {
    @GetMapping("/about")
    public String about() {
        return "This is the About page!";
    }
}
