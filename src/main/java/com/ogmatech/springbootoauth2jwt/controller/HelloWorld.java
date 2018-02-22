package com.ogmatech.springbootoauth2jwt.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String home(){
        return "Hello Raki";
    }

    @GetMapping("/api/test")
    public String apitest(){
        return "Hello api Test";
    }

    @GetMapping("/api/hello")
    public String helloUser(){
        //The authenticated user can be fetched using the SecurityContextHolder
        String username = new SecurityContextHolder().getContext().getAuthentication().getName();
        return String.format("Hello '%s'!", username);
    }

    @GetMapping("/api/admin")
    // If controller request asks for the Principal user in
    // the method declararion Spring security will provide it.
    public String helloAdmin(Principal principal){
        return String.format("Welcom '%s'!", principal.getName());

    }
}
