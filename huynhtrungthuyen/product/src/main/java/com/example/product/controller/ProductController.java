package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import com.example.product.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductTypeService iProductTypeService;

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           Model model) {
        model.addAttribute("productList", iProductService.searchProduct(nameSearch, pageable));
        model.addAttribute("productTypeList", iProductTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypeList", iProductTypeService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới sản phẩm thành công.");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = iProductService.findById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("productTypeList", iProductTypeService.findAll());
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa khách hàng thành công.");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iProductService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xoá sản phẩm [" + iProductService.findById(id).get().getProductName() + "] thành công.");
        return "redirect:/";
    }
}
