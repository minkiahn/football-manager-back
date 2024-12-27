package com.mkahn.mkahn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MkahnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MkahnApplication.class, args);

	}

}
