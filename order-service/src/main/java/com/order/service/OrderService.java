package com.order.service;

import com.order.entity.Orders;
import com.order.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public List<Orders> getAllOrders(){
        return orderRepo.findAll();
    }

    public Orders createOrders(Orders orders){
        return orderRepo.save(orders);
    }
}
