package com.CC_Assignment.secondQue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new User("Bilbo Baggins", "bagginses@gmail.com", "Burglar")));
			log.info("Preloading " + repository.save(new User("Dhruva", "random@gmail.com", "password")));
		};
	}
}
