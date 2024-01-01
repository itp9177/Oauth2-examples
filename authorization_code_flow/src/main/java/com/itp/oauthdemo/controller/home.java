package com.itp.oauthdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {

    @GetMapping(path = "/home")
    public String index(){
        return "home";
    }
}
