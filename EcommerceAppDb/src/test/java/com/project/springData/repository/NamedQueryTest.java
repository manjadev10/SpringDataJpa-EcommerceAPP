package com.project.springData.repository;

import com.project.springData.entity.Product;
import com.project.springData.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByPriceMethod(){
        List<Product> output = productRepository.findByPrice(new BigDecimal(100));
        for(Product p : output){
            System.out.println(p.getId());
            System.out.println(p.getName());
        }
    }

    @Test
    void findBySKUMethod(){
        List<Product> output = productRepository.findBySKU("100ABC");
        for(Product p : output){
            System.out.println(p.getId());
            System.out.println(p.getName());
        }
    }
}
