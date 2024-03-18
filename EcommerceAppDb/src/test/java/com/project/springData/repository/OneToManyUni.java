package com.project.springData.repository;

import com.project.springData.entity.Address;
import com.project.springData.entity.Order;
import com.project.springData.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Set;

@SpringBootTest
public class OneToManyUni {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveOrderAndItsItemsMethod(){

        Order order = new Order();

        order.setOrderTrackingNumber("100ABC");
        order.setTotalQuantity(5);
        order.setStatus("In Progress");
        order.setTotalPrice(new BigDecimal(100));

        Address address = new Address();

        address.setCity("Hubballi");
        address.setStreet("Kelamane");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("560078");
        order.setBillingAddress(address);
        order.getBillingAddress().setOrder(order); //one to one bi directional association


        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1l).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        order.getOrderItems().add(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2l).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        orderRepository.save(order);

    }

    @Test
    void fetchOrderCascade(){
        Order order = orderRepository.findById(9l).get();
        System.out.println(order.getStatus());
        order.getOrderItems().stream().map(item -> item.getProduct().getName()).forEach(System.out::println);
    }

    @Test
    void deleteOrderCascade(){  //Cascade deletion of orderItem is not working.
        orderRepository.deleteById(1l);
    }

    @Test
    void deleteAllOrder(){
        orderRepository.deleteAll();
    }




}
