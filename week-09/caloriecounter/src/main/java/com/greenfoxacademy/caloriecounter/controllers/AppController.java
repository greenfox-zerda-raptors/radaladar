/// Created by BB on 2016-12-21.
package com.greenfoxacademy.caloriecounter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller

public class AppController {

    @RequestMapping(value = "/index")
    public String index(Model model){
        ArrayList<Meal> meals = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        meals.add(new Meal(dateFormat.format(date), "Breakfast", "Teeth", 200));
        meals.add(new Meal(dateFormat.format(date), "Lunch", "Nails", 1200));
        meals.add(new Meal(dateFormat.format(date), "Dinner", "Sawdust", 0));
        int[] totalcalories = {200,1200,0};
        model.addAttribute("meals", meals);
        model.addAttribute("totalcalories",totalcalories);
        return "index";
    }
}
