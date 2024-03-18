package com.project.springData.repository;

import com.project.springData.entity.Address;
import com.project.springData.entity.Order;
import com.project.springData.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyBiDirectional {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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
        order.getBillingAddress().setOrder(order);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(7l).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        order.getOrderItems().add(orderItem1);
        order.getOrderItems().get(0).setOrder(order);


        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(8l).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        order.getOrderItems().add(orderItem2);
        order.getOrderItems().get(1).setOrder(order);


        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        orderRepository.save(order);

    }

    @Test
    void SetOrderForOrderItems(){

        Order order = orderRepository.findById(4l).get();
        OrderItem orderItem1 = orderItemRepository.findById(6l).get();
        orderItem1.setOrder(order);
        orderItemRepository.save(orderItem1);
    }

    @Test
    void fetchOrderForAOrderItem(){
        OrderItem orderItem = orderItemRepository.findById(13l).get();
        String str = orderItem.getOrder().getStatus();
        System.out.println(str);
    }

    @Test
    void deleteAllOrderCascade(){
        orderRepository.deleteAll();
    }

}
