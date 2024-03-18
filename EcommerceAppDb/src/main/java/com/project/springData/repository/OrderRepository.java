package com.project.springData.repository;

import com.project.springData.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderTrackingNumber(String orderTrackingNumber);

}
