package com.student_service_consumer_feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentConsumerController {

    private final StudentProviderClient studentProviderClient;

    public StudentConsumerController(StudentProviderClient studentProviderClient){
        this.studentProviderClient = studentProviderClient;
    }

    @GetMapping("consume")
    public String getMessage(){
        String response = studentProviderClient.getProviderMessage();
        return "FROM CONSUMER (Feign): " + response;
    }
}
