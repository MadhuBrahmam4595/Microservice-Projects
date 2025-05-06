package com.student_service_consumer_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentServiceConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceConsumerFeignApplication.class, args);
	}

}
