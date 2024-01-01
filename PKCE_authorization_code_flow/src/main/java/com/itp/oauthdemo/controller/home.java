package com.itp.oauthdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {

    @GetMapping( "/home/test")
    public String index(){
        return "home";
    }
}
