package com.kc.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbaApplication.class, args);
	}

}
