package com.jaza.software.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementServiceApplication  {
//extends SpringBootServletInitializer implements CommandLineRunner
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(TaskManagementServiceApplication.class);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Application Started !!");
//	}

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementServiceApplication.class, args);
	}

}
