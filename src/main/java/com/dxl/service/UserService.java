package com.dxl.service;


import com.dxl.pojo.User;
import com.dxl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public User findByUname(String username){
        return userMapper.selectByUname(username);
    }

    public User loginIn(String name, String password) {
        return userMapper.selectByUnamePwd(name,password);
    }

    public void saveUser(String name,String password){
        userMapper.saveUser(name, password);
    }
}