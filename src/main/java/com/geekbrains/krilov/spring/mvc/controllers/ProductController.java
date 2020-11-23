package com.geekbrains.krilov.spring.mvc.controllers;

import com.geekbrains.krilov.spring.mvc.model.Product;
import com.geekbrains.krilov.spring.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product_page")
    public String showProductPage(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "products";
    }

    @PostMapping("/add_product")
    public String addNewProduct(@RequestParam String name, @RequestParam long price) {
        Product product = new Product(name, price);
        productService.addProduct(product);
        return "redirect:/products/product_page";
    }

    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/product_page";
    }
}
