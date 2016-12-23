package com.greenfoxacademy.caloriecounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class CaloriecounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaloriecounterApplication.class, args);
	}
}
