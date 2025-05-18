package com.order.service;

import com.order.client.CustomerClient;
import com.order.model.Customer;
import com.order.model.CustomerResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerClient customerClient;

    public CustomerService(CustomerClient customerClient){
        this.customerClient = customerClient;
    }

    @CircuitBreaker(name="customerServiceCB", fallbackMethod = "fallbackGetCustomer")
    public CustomerResponse getCustomerById(Long id){
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customerById = customerClient.getCustomerById(id);
        logger.info("customerById:{}", customerById.toString());
        if(customerById!=null){
            customerResponse.setCustomer(customerById);
            customerResponse.setIsError(Boolean.FALSE);
        }
        return customerResponse;
    }

    public CustomerResponse fallbackGetCustomer(Long id, Throwable throwable){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setIsError(Boolean.TRUE);
        customerResponse.setErrorMsg("Customer service is not available. Please try again");
        return customerResponse;
    }

}
