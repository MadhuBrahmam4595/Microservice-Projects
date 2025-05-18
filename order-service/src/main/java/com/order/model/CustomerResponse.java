package com.order.model;

public class CustomerResponse {

    private Customer customer;
    private Boolean isError;
    private String errorMsg;

    public CustomerResponse() {
    }

    public CustomerResponse(Customer customer, Boolean isError, String errorMsg) {
        this.customer = customer;
        this.isError = isError;
        this.errorMsg = errorMsg;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }


    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customer=" + customer +
                ", isError=" + isError +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
