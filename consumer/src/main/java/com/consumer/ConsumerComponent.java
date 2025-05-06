package com.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerComponent implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9000/provider/show", String.class);
        System.out.println(forEntity.getBody());
        System.out.println("========Message from Admin Consumer==========");
    }
}
