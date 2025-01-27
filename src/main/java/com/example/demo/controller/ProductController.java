package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products); // Add products to the model to display them in the view
        return "products"; // This refers to products.html (Thymeleaf template)
    }

    // Show form to add a new product
    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        logger.info("Displaying form to add a new product...");
        model.addAttribute("product", new Product());
        return "product_form"; // This refers to product_form.html
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute Product product) {
        logger.info("Attempting to add a new product: {}", product);

        // Validate and save the product
        try {
            productService.saveProduct(product);
            logger.info("Product added successfully: {}", product);
        } catch (Exception e) {
            logger.error("Error while adding product: {}", e.getMessage());
            throw e; // Re-throw the exception to be handled by the global exception handler
        }

        return "redirect:/products"; // Redirect to the list of products after adding
    }
}