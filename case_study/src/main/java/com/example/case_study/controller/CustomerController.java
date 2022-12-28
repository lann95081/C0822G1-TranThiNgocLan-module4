package com.example.case_study.controller;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.service.customer.ICustomerService;
import com.example.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String showList(Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch,
                           @RequestParam(value = "customerTypeSearch", defaultValue = "") String customerTypeSearch, Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", iCustomerService.searchCustomer(nameSearch, emailSearch, customerTypeSearch, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("customerTypeSearch", customerTypeSearch);
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

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id).get();
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa khách hàng thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(@PathVariable(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iCustomerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("message", "Xoá khách hàng " +
                "[" + iCustomerService.findById(id).get().getCustomerName() + "] thành công!");
        return "redirect:/customer";
    }
}
