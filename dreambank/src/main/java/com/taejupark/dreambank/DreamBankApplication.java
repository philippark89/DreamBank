package com.taejupark.dreambank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DreamBankApplication {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(DreamBankApplication.class, args);
	}

	@Bean
	public CommandLineRunner webApplicationStartMessage() {
		return args -> logger.info("DreamBank web application got started!");
	}

	@Bean
	public CommandLineRunner addAdminRoles() {
		return null;
	}
}
