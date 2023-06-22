package com.example.myinteractivecv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class GreetingsController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/greetings")
    public String test() {
        return "greetings";
    }
}
