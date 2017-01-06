package com.greenfoxacademy.caloriecounter;

import com.greenfoxacademy.caloriecounter.domain.Meal;
import com.greenfoxacademy.caloriecounter.domain.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class CaloriecounterApplication implements CommandLineRunner{

	@Autowired
	private MealRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CaloriecounterApplication.class, args);
	}


//	LOAD DUMMY DATA
	@Override
	public void run(String... args) throws Exception {
		int[] calories = {0,1000,3456,311,-144,735};
		String[] type = {"Breakfast", "Elevenses", "Lunch", "Snack", "Dinner", "Midnight Snack"};
		String[] description = {"Migraine", "Hobbitses", "Like, a bunch of hamburgers", "Chocolate", "Panic", "Leftovers"};
		for (int i = 0; i < 12; i++) {
			repository.save(new Meal(calories[i % 6],"2017-01-"+((i/6 % 30) + 1) ,type[i % 6], description[i % 6]));
		}
	}
}
