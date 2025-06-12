package com.my.company.endpoint.rest.controller.health;

import com.my.company.service.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    /*
    @GetMapping("/hello")
    public String helloWorld() {
        return "... world!";
    }
     */

    private final HelloWorldService service;

    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam String name) {
        return service.uploadHelloWorldMessage(name);
    }
}