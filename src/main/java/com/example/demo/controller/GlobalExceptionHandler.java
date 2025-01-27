package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle 404 Errors (Page Not Found)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError(NoHandlerFoundException ex, Model model, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Set 404 status explicitly
        model.addAttribute("error", "404 - Page Not Found");
        model.addAttribute("message", "The page you are looking for could not be found: " + ex.getMessage());
        return "error"; // Use error.html template
    }

    // Handle 500 Errors (Internal Server Error) or General Exceptions
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Set 500 status explicitly
        model.addAttribute("error", "500 - Internal Server Error");
        model.addAttribute("message", "Oops, something went wrong! " + ex.getMessage());
        return "error"; // Use error.html template
    }
}
