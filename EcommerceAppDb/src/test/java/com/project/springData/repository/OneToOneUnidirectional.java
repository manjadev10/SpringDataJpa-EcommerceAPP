package com.project.springData.repository;

import com.project.springData.entity.Address;
import com.project.springData.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class OneToOneUnidirectional {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrder(){

        Order order = new Order();

        order.setOrderTrackingNumber("100ABC");
        order.setTotalQuantity(5);
        order.setStatus("In Progress");
        order.setTotalPrice(new BigDecimal(100));

        Address address = new Address();

        address.setCity("Bengaluru");
        address.setStreet("Prashanth layout");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("560066");

        order.setBillingAddress(address);

        orderRepository.save(order);

    }

    @Test
    void updateOrder(){
        Order order = orderRepository.findById(1L).get();
        order.setStatus("Delivered");
        //order.getBillingAddress().setZipcode("460055");
        orderRepository.save(order);
    }

    @Test
    void deleteOrder(){
        orderRepository.deleteById(2l);
    }
}
