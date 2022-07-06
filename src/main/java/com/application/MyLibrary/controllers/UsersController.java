package com.application.MyLibrary.controllers;

import com.application.MyLibrary.models.UsersModel;
import com.application.MyLibrary.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {


    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
        return "register-page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login-page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel userModel) {
        System.out.println("register request: " + userModel);
        UsersModel registeredUser = usersService.registerUser(userModel.getLogin(), userModel.getPassword(), userModel.getEmail());
        return registeredUser == null ? "error-page": "redirect:/login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel userModel, Model model) {
        System.out.println("login request: " + userModel);
        UsersModel authenticated = usersService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "fragments/header";
        }else {
            return "error-page";
        }
    }

}
