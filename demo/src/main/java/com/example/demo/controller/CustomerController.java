package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import com.sun.xml.internal.ws.wsdl.writer.document.Binding;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @Autowired
    private ICustomerService iCustomerService;

//    @GetMapping("")
//    public String showList(@PageableDefault(value = 8) Pageable pageable,
//                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
//                           @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch,
//                           Model model) {
////        List<Customer> customerList = iCustomerService.findAll();
////        for (Customer customer : customerList) {
////            if (customer.getCustomerBirthday().contains("-")) {
////                String[] arr = customer.getCustomerBirthday().split("-");
////                customer.setCustomerBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
////            }
////        }
//
//        model.addAttribute("customerList", iCustomerService.searchCustomer(nameSearch, emailSearch, pageable));
//        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
//        model.addAttribute("nameSearch", nameSearch);
//        model.addAttribute("emailSearch", emailSearch);
//
//        return "customer/list";
//    }

    @GetMapping("")
    public String showList(@PageableDefault(value = 8) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch,
                           @RequestParam(value = "typeSearch", defaultValue = "") String typeSearch,
                           Model model) {
//        List<Customer> customerList = iCustomerService.findAll();
//        for (Customer customer : customerList) {
//            if (customer.getCustomerBirthday().contains("-")) {
//                String[] arr = customer.getCustomerBirthday().split("-");
//                customer.setCustomerBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
//            }
//        }

        model.addAttribute("customerList", iCustomerService.searchCustomer(nameSearch, emailSearch,typeSearch, pageable));
        System.out.println(iCustomerService.searchCustomer(nameSearch, emailSearch,typeSearch, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("emailSearch", emailSearch);
        model.addAttribute("typeSearch", typeSearch);

        return "customer/list";
    }

    @GetMapping("/delete")
    public String deleteCus(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iCustomerService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xóa khách hàng  [" +
                iCustomerService.findById(id).get().getCustomerName() + "]  thành công.");

        return "redirect:/";
    }

    @GetMapping("/create")
    public String createCus(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "customer/create";
    }

    @PostMapping("/add")
    public String saveCus(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCus(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id).get();

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCus(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

            return "customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa khách hàng thành công!");

        return "redirect:/";
    }
}
