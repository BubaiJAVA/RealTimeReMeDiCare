package com.udaynarayan.LogInSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LogInSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogInSecurityApplication.class, args);
	}

}
