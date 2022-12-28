package com.example.cart_app.controller;

import com.example.cart_app.dto.CartDto;
import com.example.cart_app.dto.ProductDto;
import com.example.cart_app.model.Product;
import com.example.cart_app.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/app")
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

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("product/detail", "product", iProductService.findById(id).get());
    }

    @GetMapping
    public ModelAndView showListPage(Model model,
                                     @CookieValue(value = "idProduct", defaultValue = "-1") Long id) {
        if (id != -1) {
            model.addAttribute("historyProduct", iProductService.findById(id));
        }
        return new ModelAndView("/product/list", "productList", iProductService.findAll());
    }
}
