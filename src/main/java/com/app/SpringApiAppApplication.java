package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiAppApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(SpringApiAppApplication.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);
	}
}
