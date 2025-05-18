package com.order.controller;

import com.order.entity.Orders;
import com.order.model.CustomerResponse;
import com.order.service.CustomerService;
import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final CustomerService customerService;
    private final OrderService orderService;

    public OrderController(CustomerService customerService, OrderService orderService){
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping("place-order")
    public ResponseEntity<String> placeOrder(@RequestBody Orders order){
        CustomerResponse customerResponse = customerService.getCustomerById(order.getCustomerId());
        logger.info("customerResponse:{}", customerResponse.toString());
        if(customerResponse.getErrorMsg()!=null&&customerResponse.getErrorMsg().contains("Customer service is not available.")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerResponse.getErrorMsg());
        }else{
            if(customerResponse.getErrorMsg()!=null&&customerResponse.getErrorMsg().contains("Customer service is temporary not available.")){
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(customerResponse.getErrorMsg());
            }
            return ResponseEntity.ok("Order placed for customer:"+orderService.createOrders(order));
        }
    }

    @GetMapping("orders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
