package com.springboot.pattern.springbootpattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHallo {

    @GetMapping(value = "/api/hallo")
    public String getHallo(){
        return "Hallo Spring One !";
    }
}
