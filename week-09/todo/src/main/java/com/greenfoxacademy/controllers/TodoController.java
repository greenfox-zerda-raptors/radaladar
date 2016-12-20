/// Created by BB on 2016-12-20.
package com.greenfoxacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @RequestMapping(value = {"/", "/list"})
    public String list(Model model, @RequestParam(required = false, defaultValue = "false") String active){
        model.addAttribute("active", Boolean.valueOf(active));
        model.addAttribute("todos", todoService.getTodos());
        return "/todo/list";
    }
}
