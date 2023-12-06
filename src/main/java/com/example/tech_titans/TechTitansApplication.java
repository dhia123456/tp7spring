package com.example.tech_titans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TechTitansApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechTitansApplication.class, args);
	}

}
