package com.order.client;

import com.order.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service", url = "http://localhost:8082")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable("id") Long id);


}
