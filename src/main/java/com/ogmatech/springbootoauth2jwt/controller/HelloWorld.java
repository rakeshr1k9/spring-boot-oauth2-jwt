package com.ogmatech.springbootoauth2jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/")
    public String home(){
        return "Hello Raki";
    }
}
