package com.my.company.endpoint.rest.controller.health;

import com.my.company.endpoint.event.EventProducer;
import com.my.company.endpoint.event.model.SendEmailRequested;
import com.my.company.service.HelloWorldService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    /*
    @GetMapping("/hello")
    public String helloWorld() {
        return "... world!";
    }
     */

    private final HelloWorldService service;

    public HelloWorldController(HelloWorldService service, EventProducer<SendEmailRequested> eventProducer) {
        this.service = service;
        this.eventProducer = eventProducer;
    }

    /*
    @GetMapping("/hello")
    public String helloWorld(@RequestParam String name) {
        return service.uploadHelloWorldMessage(name);
    }
     */

    private final EventProducer<SendEmailRequested> eventProducer;

    @GetMapping("/hello")
    @SneakyThrows
    public String helloWorld(@RequestParam String to) {
        var event = SendEmailRequested.builder().to(to).build();
        eventProducer.accept(List.of(event));
        return "... world!";
    }
}