package com.atguigu.springboot.service;


import com.atguigu.springboot.model.User;


public interface UserService {

    public User getUser(String username);

    void insertUserByUsernameAndPassword(String username, String password);
}
