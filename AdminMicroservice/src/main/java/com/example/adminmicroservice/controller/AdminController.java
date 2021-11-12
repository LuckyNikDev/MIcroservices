package com.example.adminmicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminController {
    @GetMapping("/foradmin")
    public String getMessage(@RequestHeader Map headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return "Congrate! You are admin.";
    }
}
