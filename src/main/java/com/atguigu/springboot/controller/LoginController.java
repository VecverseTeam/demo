package com.atguigu.springboot.controller;

import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object>map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && (userService.getUser(username).getUsername()).equals(username) &&
                (userService.getUser(username).getPassword()).equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            /*System.out.println(map);*/
            return "redirect:/";
        }
    }

    @PostMapping("/user/register")
    public String register(){
        return "register";
    }
}
