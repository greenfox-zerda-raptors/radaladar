/// Created by BB on 2016-12-19.
package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {

    private final AtomicLong counter = new AtomicLong();

    private String[][] hellos = {{"Mirëdita", "red", "14"},
            {"Ahalan", "blue","12"},
            {"Parev", "green","40"},
            {"Zdravei", "brown","22"},
            {"Nei Ho", "orange","38"},
            {"Dobrý den", "yellow","10"},
            {"Ahoj", "pink","16"},
            {"Goddag", "red","12"},
            {"Goede dag, Hallo","navy","24"},
            {"Hello","silver","12"},
            {"Saluton","black","23"},
            {"Hei","magenta","6"},
            {"Bonjour","olive","20"}};
//            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
//            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
//            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    @RequestMapping("/web/greeting")
    public String greeting(Model model, @RequestParam String name) {
        model.addAttribute("hellos", hellos);
        model.addAttribute("name", name);
        model.addAttribute("counter", counter.incrementAndGet());
        return "greeting";
    }
}
