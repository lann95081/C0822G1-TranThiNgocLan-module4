package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductManagementService iProductManagementService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> productList = iProductManagementService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductManagementService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Add new product successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductManagementService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductManagementService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Update product successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductManagementService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        iProductManagementService.remove(product.getId());
        redirectAttributes.addFlashAttribute("mess", "Delete product successfully!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductManagementService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String showListSearch(@RequestParam String name, Model model) {
        model.addAttribute("productList", iProductManagementService.findByName(name));
        return "/list";
    }
}
