package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @PostMapping("/project")
    public String project(){
        return "dashboard";
    }

    @PostMapping("/product")
    public String product(){
        return "product";
    }

}
