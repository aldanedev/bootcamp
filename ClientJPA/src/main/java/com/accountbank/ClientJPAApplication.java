package com.accountbank;

import com.accountbank.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ClientJPAApplication {
	@Autowired
	private TypeService typeService;

	public static void main(String[] args) {
		SpringApplication.run(ClientJPAApplication.class, args);
	}
}