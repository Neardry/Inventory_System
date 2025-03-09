package com.near.Inventory_System.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("")
    public String post(@RequestBody String body) {
        return "a";
    }
}
