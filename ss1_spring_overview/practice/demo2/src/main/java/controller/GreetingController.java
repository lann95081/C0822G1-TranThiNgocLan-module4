package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@WebServlet(servletName="YourServlet", urlPatterns={"/*"})
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "index";
    }
}