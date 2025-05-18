package com.kafka_inventory_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka_inventory_service.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume(String message) {
        try {
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println("Order received: " + order.getOrderId()+" "+order.getProductName()+" "+order.getQuantity());
            System.out.println("Inventory updated for product:"+order.getProductName()+" quantity:"+order.getQuantity());
        } catch (Exception e) {
            System.out.println("Failed to process order: " + e.getMessage());
        }
    }
}
