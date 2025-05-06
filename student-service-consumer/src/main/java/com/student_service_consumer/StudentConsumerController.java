package com.student_service_consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentConsumerController {

    private final RestTemplate restTemplate;

    public StudentConsumerController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("consume")
    public String getMsg(){
        //ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9800/provider/show", String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://STUDENT-SERVICE-PROVIDER/provider/show", String.class);
        System.out.println(forEntity.getBody());
        return "FROM CONSUMER:"+forEntity.getBody();
    }
}
