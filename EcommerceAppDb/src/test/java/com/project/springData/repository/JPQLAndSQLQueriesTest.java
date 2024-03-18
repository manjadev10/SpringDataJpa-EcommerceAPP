package com.project.springData.repository;

import com.project.springData.entity.Product;
import com.project.springData.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPQLAndSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexedParam(){
        List<Product> output = productRepository.findByNameOrDescriptionJPQLIndexParam("product 2","product 2 description");

        output.forEach(p -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void findByNameOrDescriptionJPQLIndexParam(){
        List<Product> output = productRepository.findByNameOrDescriptionJPQLNamedParam("product 2","product 2 description");

        output.forEach(p -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void findByNameOrDescriptionSQLIndexParam(){
        List<Product> output = productRepository.findByNameOrDescriptionSQLNamedParam("product 2","product 2 description");

        output.forEach(p -> {
            System.out.println(p.getName());
        });

    }
}
