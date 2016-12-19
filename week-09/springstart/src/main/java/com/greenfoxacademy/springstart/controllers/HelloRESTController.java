/// Created by BB on 2016-12-19.
package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping
    public String greeting(@RequestParam String name){
        Greeting greet = new Greeting(counter.incrementAndGet(), "aaa");
        return "id: " + greet.getId() + ", content: " + greet.getContent() + " Hello, " + name + "!";
    }
}
