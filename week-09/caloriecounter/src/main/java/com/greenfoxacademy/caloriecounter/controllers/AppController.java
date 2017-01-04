/// Created by BB on 2016-12-21.
package com.greenfoxacademy.caloriecounter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    private SQLHandler SQLHandler;

    @Autowired
    public void setSQLHandler(com.greenfoxacademy.caloriecounter.controllers.SQLHandler SQLHandler) {
        this.SQLHandler = SQLHandler;
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        try {
            model.addAttribute("meals", SQLHandler.loadMeals());
            model.addAttribute("sum", SQLHandler.loadCaloriesSum());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/del/{id}")
    public String delete(Model model, @PathVariable("id") int id){
        try {
        SQLHandler.deleteMeal(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return index(model);
    }

    @RequestMapping(value ="/addmeal")
    public String addMeal(Model model) {
        return "addmeal";
    }
}
