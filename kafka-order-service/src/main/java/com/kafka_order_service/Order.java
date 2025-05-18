package com.kafka_order_service;

public class Order {

    private String orderId;
    private String productName;
    private int quantity;

    public Order() {
    }

    public Order(String orderId, String productName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getProductName() {
        return productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity + "]";
    }
}
