package com.se_lab.residentConsentFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ResidentConsentFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResidentConsentFrameworkApplication.class, args);
	}

}
