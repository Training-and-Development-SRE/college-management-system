package com.iiht.training.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CollegeManagementSystemApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CollegeManagementSystemApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemApplication.class, args);
	}

}
