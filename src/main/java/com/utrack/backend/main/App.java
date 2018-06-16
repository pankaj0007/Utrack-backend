package com.utrack.backend.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@RestController
@EnableAutoConfiguration
public class App {
	
	@RequestMapping("/")
	public String home() {
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
