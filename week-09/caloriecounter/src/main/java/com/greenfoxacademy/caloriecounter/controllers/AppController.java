/// Created by BB on 2016-12-21.
package com.greenfoxacademy.caloriecounter.controllers;

import com.greenfoxacademy.caloriecounter.domain.Meal;
import com.greenfoxacademy.caloriecounter.domain.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @Autowired
    private MealRepository mealRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){
            model.addAttribute("meals", mealRepository.findAll());
            int sum = 0;
            for (Meal meal: mealRepository.findAll()) {
                sum += meal.getCalories();
            }
            model.addAttribute("sum", sum);
        return "index";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") long id){
        mealRepository.delete(id);
        return "redirect:/index";
    }
}
