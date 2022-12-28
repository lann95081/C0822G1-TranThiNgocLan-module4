package com.example.cart_app.controller;

import com.example.cart_app.dto.CartDto;
import com.example.cart_app.dto.ProductDto;
import com.example.cart_app.model.Product;
import com.example.cart_app.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cartDto) {

        Product product = iProductService.findById(id).orElse(null);

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }
}
