package com.zaahid.user_management.controller;

import java.util.List;

import com.zaahid.user_management.model.User;
import com.zaahid.user_management.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/save", method =RequestMethod.POST)
    public String saveUser(@ModelAttribute User user){
        services.save(user);
        return "redirect:/";
    }

    @RequestMapping("edit/{uid}")
    public ModelAndView EditUserPage(@PathVariable (name="uid") Long uid){
        ModelAndView mav=new ModelAndView("edit_user");
        User user=services.get(uid);
        mav.addObject("user", user);
        return mav;
    }
}
