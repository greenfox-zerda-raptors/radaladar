/// Created by BB on 2016-12-20.
package com.greenfoxacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping(value = "/helloworld")
    public String helloWorld(Model model, @RequestParam(required = false) String name){
        if (name == null) {
            model.addAttribute("name", "Thymeleaf");
        } else {
            model.addAttribute("name", name);
        }
        model.addAttribute("date", new Date());
        return "greeting";
    }
}
