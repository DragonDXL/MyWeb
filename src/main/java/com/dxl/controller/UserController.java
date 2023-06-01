package com.dxl.controller;

import com.dxl.pojo.User;
import com.dxl.mapper.UserMapper;
import com.dxl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        return "login";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "register";
    }


    @RequestMapping("/user/login")
    public String userLogin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("username:{}",username);
        log.info("password:{}",password );
        User user = userService.loginIn(username, password);
        if(user != null){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/user/register")
    public String userRegister(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        log.info("username:{}",username);
        log.info("pasword:{}",password );
        log.info("pasword2:{}",password2 );
        User user = userService.findByUname(username);
        if(user == null && password.equals(password2)){
            userService.saveUser(username,password);
            return "success";
        }else{
            return "error";
        }
    }
}
