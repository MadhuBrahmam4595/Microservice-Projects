package com.order.repo;

import com.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Long> {
}
