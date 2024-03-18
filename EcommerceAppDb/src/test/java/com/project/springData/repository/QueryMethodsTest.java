package com.project.springData.repository;

import com.project.springData.entity.Product;
import com.project.springData.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product response = productRepository.findByName("product 2");
        System.out.println(response);
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> output = productRepository.findByNameAndDescription("product 2","product 2 description");
        for(Product p : output){
            System.out.println(p.getId());
        }
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> output = productRepository.findByNameOrDescription("product 3","product 2 description");
        for(Product p : output){
            System.out.println(p.getId());
            System.out.println((p.getLastUpdated()));
        }
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> output = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        for(Product p : output){
            System.out.println(p.getId());
            System.out.println((p.getLastUpdated()));
            System.out.println(p.getPrice());
        }

    }

    @Test
    void findByPriceGreaterThanEqualMethod(){
        List<Product> output = productRepository.findByPriceGreaterThanEqual(new BigDecimal(100));
        for(Product p : output){
            System.out.println(p.getId());
            System.out.println((p.getLastUpdated()));
            System.out.println(p.getPrice());
        }

    }

    @Test
    void findByNameContainingMethod(){
        List<Product> output = productRepository.findByNameContaining("product");
        for(Product p : output){
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println((p.getLastUpdated()));
            System.out.println(p.getPrice());
        }
    }

    @Test
    void findByCreateOnBetweenMethod(){
        LocalDateTime startDate = LocalDateTime.of(2024,03,12,00,00);
        LocalDateTime endDate = LocalDateTime.of(2024,03,13,23,00);
        List<Product> output = productRepository.findByCreatedOnBetween(startDate,endDate);
        for(Product p : output){
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println((p.getCreatedOn()));
            System.out.println(p.getPrice());
        }
    }

    @Test
    void findByNameIn(){
        List<String> names = List.of("product 1","product 2");
        List<Product> output = productRepository.findByNameIn(names);
        for (Product p : output) {
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println((p.getCreatedOn()));
            System.out.println(p.getPrice());
        }

    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> output = productRepository.findFirst2ByOrderByNameAsc();
        for (Product p : output) {
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println((p.getCreatedOn()));
            System.out.println(p.getPrice());
        }

    }


}
