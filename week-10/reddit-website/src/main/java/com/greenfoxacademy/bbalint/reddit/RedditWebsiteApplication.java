package com.greenfoxacademy.bbalint.reddit;

import com.greenfoxacademy.bbalint.reddit.domain.Post;
import com.greenfoxacademy.bbalint.reddit.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class RedditWebsiteApplication implements CommandLineRunner{

    @Autowired
    private PostRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RedditWebsiteApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i<5; i++) {
            repository.save(new Post(i, "Message number #"+(i+1)));
        }
    }
}
