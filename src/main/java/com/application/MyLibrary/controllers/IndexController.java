package com.application.MyLibrary.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/")
    public String listHome(){
        return "index";
    }
}
