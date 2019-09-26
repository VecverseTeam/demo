package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.mapper.UserMapper;
import com.atguigu.springboot.model.User;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void insertUserByUsernameAndPassword(String username, String password) {
        userMapper.insertUserByUsernameAndPassword(username,password);
    }
}
