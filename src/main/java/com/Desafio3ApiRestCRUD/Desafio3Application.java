package com.Desafio3ApiRestCRUD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}

}
