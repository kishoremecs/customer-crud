package com.practice;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
	
}