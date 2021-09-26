package com.cscs.cscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CscoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CscoreApplication.class, args);
	}

}
