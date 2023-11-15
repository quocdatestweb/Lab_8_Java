package com.example.lab8.controllers;

import com.example.lab8.Repository.ProductRepository;
import com.example.lab8.Repository.ProductService;
import com.example.lab8.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("admin/api/")
public class ProductController {
    @Autowired private ProductService productService;
    @GetMapping("products")
    public List<Product> getProductsAPI()
    {
        return productService.listAllProducts();
    }
}
