package com.order.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String id){
        super("Customer is not found with given id:"+id);
    }
}
