package com.student_service_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentServiceProviderApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentServiceProviderApplication.class, args);
		System.out.println("===Student Service Provider Application===");
	}

}
