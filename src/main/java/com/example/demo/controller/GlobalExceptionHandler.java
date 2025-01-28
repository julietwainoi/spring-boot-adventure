package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, Model model) {
        logger.error("An error occurred: {}", ex.getMessage(), ex);

        // Create a ModelAndView object to pass the error details to the view
        ModelAndView modelAndView = new ModelAndView("error"); // Refers to error.html
        modelAndView.addObject("error", "An unexpected error occurred");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}
