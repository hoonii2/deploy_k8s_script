package com.k8s.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String doProductHtml(){
        return "product";
    }
}
