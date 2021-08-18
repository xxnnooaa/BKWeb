package com.example.bkweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BkwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BkwebApplication.class, args);
	}

}
