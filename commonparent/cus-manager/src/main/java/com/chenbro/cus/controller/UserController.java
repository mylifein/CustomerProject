package com.chenbro.cus.controller;

import com.chenbro.cus.model.User;
import com.chenbro.cus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @ClassName com.chenbro.cus.controller.UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 15:22
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login(){
        User user = userService.findById("1");
        System.out.println("璐璐真漂亮");

        return  null;
    }

    @RequestMapping("home")
    public String homePage(){
        return "home";
    }
}
