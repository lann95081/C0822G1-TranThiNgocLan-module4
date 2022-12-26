package com.example.case_study.controller;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.service.customer.ICustomerService;
import com.example.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/add")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");
        return "redirect:/customer";
    }
}
