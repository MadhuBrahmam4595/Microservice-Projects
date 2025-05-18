package com.kafka_order_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final String TOPIC = "order-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public String placeOrder(@RequestBody Order order)throws JsonProcessingException {
        String orderJson = objectMapper.writeValueAsString(order);
        kafkaTemplate.send(TOPIC, orderJson);
        return "Order sent to kafka successfully";
    }
}
