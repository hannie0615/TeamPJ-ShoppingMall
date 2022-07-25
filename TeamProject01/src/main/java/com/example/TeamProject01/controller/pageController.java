package com.example.TeamProject01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class pageController {

    @PostMapping("/register")
    public String goRegister() {
        return "member/register";
    }

    @PostMapping("/login")
    public String goLogin(){
        return "member/login";
    }
}
