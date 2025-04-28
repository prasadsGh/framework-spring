package com.edigest.myFirstProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/getHello")
    public String getHello(){
        return "hello";
    }
}
