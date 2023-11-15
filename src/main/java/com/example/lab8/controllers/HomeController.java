package com.example.lab8.controllers;

import com.example.lab8.Repository.ProductRepository;
import com.example.lab8.Repository.ProductService;
import com.example.lab8.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/products/")
public class HomeController {
    @Autowired private ProductService productService;

    @GetMapping(value = {"/", "/home",})
    public String showHomePage(Model model)
    {
        List<Product> productList = productService.listAllProducts();
        model.addAttribute("listProducts",productList);
        return "index";
    }
    @GetMapping("edit/{id}")
    public String editProduct(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes)
    {

        return "redirect:/products/";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes)
    {
        try {
            productService.deleteProduct(id);
        }
        catch (UsernameNotFoundException e)
        {
        }
        return "redirect:/products/";
    }

    @GetMapping ("addproduct")
    public String AddProduct(Model model)
    {
        model.addAttribute("product",new Product());
        return "addproduct";
    }
    @PostMapping("addproduct")
    public String postingAdd(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }
    @GetMapping("?page={page}")
    public ModelAndView PageAbout(@RequestParam(name = "about") String requestParam)
    {
        return new ModelAndView("about");
    }

}
