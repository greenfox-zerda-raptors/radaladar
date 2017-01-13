package com.exampractice;

import com.exampractice.domain.WebShopItem;
import com.exampractice.domain.WebShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class PracticeForExamApplication{

	public static void main(String[] args) {
		SpringApplication.run(PracticeForExamApplication.class, args);
	}

}
