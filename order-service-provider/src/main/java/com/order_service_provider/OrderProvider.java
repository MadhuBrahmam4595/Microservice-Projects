package com.order_service_provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderProvider {

    @Value("${server.port}")
    private String port;

    @GetMapping("status")
    public String orderGetStatus(){
        return "FINISHED: "+port;
    }
}
