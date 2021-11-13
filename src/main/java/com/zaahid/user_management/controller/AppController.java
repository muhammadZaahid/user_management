package com.zaahid.user_management.controller;

import java.util.List;

import com.zaahid.user_management.model.User;
import com.zaahid.user_management.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    
    @Autowired
    UserServices services;

    @RequestMapping("/")
    public String HomePage(Model model){
        List<User> listUser = services.listAll();
        model.addAttribute("listUser", listUser);
        return "index";
    }

    @RequestMapping("/new")
    public String NewUserPage(Model model){
        User user = new User();
        model.addAttribute(user);
        return "new_user";
    }
}
