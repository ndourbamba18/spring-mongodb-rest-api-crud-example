package com.ndourcodeur.springemployeerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class SpringEmployeeRestApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringEmployeeRestApiApplication.class, args);

		System.out.print("Server is running...");
	}

}
