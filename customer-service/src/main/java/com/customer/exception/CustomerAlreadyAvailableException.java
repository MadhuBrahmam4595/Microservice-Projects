package com.customer.exception;

public class CustomerAlreadyAvailableException extends RuntimeException{

    public CustomerAlreadyAvailableException(String email){
        super("Customer is already available with email id:"+email);
    }
}
