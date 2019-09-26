package com.atguigu.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

/*    @RequestMapping({"/","login.html"})
    public String index(){
        return "index";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/success")
        public String success(Map<String,Object> map){
        map.put("hello","<h1>你好！！！</h1>");
        map.put("users", Arrays.asList("No.1","No.2","No.3"));
        return "success";
    }
}
