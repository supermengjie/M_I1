package com.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @GetMapping("/")
    public String helloworld(){
        StringBuilder sb= new StringBuilder("hello world");
        return sb.toString();
    }
}
