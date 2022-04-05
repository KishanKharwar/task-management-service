package com.jaza.software.tms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = {"com/jaza/software/tms/controller","com/jaza/software/tms/services"})
@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com/jaza/software/tms/entities","com/jaza/software/tms/repositories"})
public class TaskManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementServiceApplication.class, args);
	}

}
