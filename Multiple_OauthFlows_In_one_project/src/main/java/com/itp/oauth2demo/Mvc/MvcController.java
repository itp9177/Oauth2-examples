package com.itp.oauth2demo.Mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("/mvc/test")
    public String index(){
        return "index";
    }
}
