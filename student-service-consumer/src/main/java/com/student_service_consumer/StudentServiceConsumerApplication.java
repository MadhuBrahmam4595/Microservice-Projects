package com.student_service_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentServiceConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentServiceConsumerApplication.class, args);
		System.out.println("====Hello from Student Service Consumer Application========");
	}

}
