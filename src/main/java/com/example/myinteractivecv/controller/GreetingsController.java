package com.example.myinteractivecv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greetings")
public class GreetingsController {

    @GetMapping
    public String test() {
        return "home";
    }
}
