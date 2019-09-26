package com.atguigu.springboot.controller;

import com.atguigu.springboot.model.User;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register/done")
    public String register_done(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("password_confirm") String password_confirm,
                                Map<String,Object>map) {
        if (userService.getUser(username) == null && password.equals(password_confirm)) {
            //写入数据库
            userService.insertUserByUsernameAndPassword(username,password);
            map.put("msg","注册成功！");
            return "redirect:/";
        } else if(userService.getUser(username) == null && !password.equals(password_confirm)){
            map.put("msg","两次密码不一致！");
            return "redirect:/";
        }
        else if (!StringUtils.isEmpty(username) &&
                    username.equals(userService.getUser(username).getUsername())) {
            map.put("msg", "用户已存在！");
            return "register";
        }
        return "login";
    }
}
