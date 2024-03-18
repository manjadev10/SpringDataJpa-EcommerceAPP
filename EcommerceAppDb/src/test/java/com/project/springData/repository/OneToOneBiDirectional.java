package com.project.springData.repository;

import com.project.springData.entity.Address;
import com.project.springData.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBiDirectional {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;

    //Bi Directional Mapping makes it possible to save order via address also
    @Test
    void saveAddressMethod(){

        Order order = new Order();

        order.setOrderTrackingNumber("500ABC");
        order.setTotalQuantity(15);
        order.setStatus("In Progress");
        order.setTotalPrice(new BigDecimal(700));

        Address address = new Address();

        address.setCity("Mangaluru");
        address.setStreet("Melamane");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("560066");

        address.setOrder(order);

        addressRepository.save(address);


    }

    @Test
    void saveOrderMethod(){
        Order order = new Order();

        order.setOrderTrackingNumber("300ABC");
        order.setTotalQuantity(10);
        order.setStatus("In Progress");
        order.setTotalPrice(new BigDecimal(400));

        Address address = new Address();

        address.setCity("Hubballi");
        address.setStreet("Kelamane");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("560078");

        order.setBillingAddress(address);
        address.setOrder(order); //bi directional association
        orderRepository.save(order);
    }

    @Test
    void fetchAddress(){

        Address address = addressRepository.findById(1l).get();

        address.getOrder();

        System.out.println(address.getOrder().getStatus());


    }

    @Test
    void DeleteAddress(){

        addressRepository.deleteById(1l);
    }

    @Test
    void DeleteOrder(){
        orderRepository.deleteById(3l);
    }


}
