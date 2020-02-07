package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookShelvesBootApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BookShelvesBootApplication.class);
		
		Map<String, Object> defaultProperties = new HashMap<String, Object>();
		defaultProperties.put("server.port", "8080");
		defaultProperties.put("spring.jpa.show-sql", "true");
		
		app.setDefaultProperties(defaultProperties);
		
		app.run(args);
	}
}
