package com.quamtech.startupinvestissement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class StartupinvestissementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartupinvestissementApplication.class, args);
	}

}
