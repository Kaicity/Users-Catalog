package com.DisplayMakers.SpringAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.DisplayMakers.SpringAPI.model.Users;
import com.DisplayMakers.SpringAPI.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userservice) {
        this.userService = userservice;
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("registerRequest", new Users());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model ) {
        model.addAttribute("loginRequest", new Users());
        return "login_page";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute Users user){
        Users registeredUsers= userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUsers == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users user, Model model){
        Users authenticated= userService.authenticate(user.getLogin(), user.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin",authenticated.getLogin());
            return"user_page";
        } else {
            return  "error_page" ;
        }

    }

}

