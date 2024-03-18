package com.project.springData.repository;

import com.project.springData.entity.Product;
import com.project.springData.entity.ProductCategory;
import com.project.springData.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Test
    void saveMethod() {
        //Crete Object
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save entity
        Product savedObject = productRepository.save(product);

        //get saved entity
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void saveMethod2() {
        //Crete Object
        Product product = new Product();
        product.setName("product 5");
        product.setDescription("product 5 description");
        product.setSku("500ABC");
        product.setPrice(new BigDecimal(500));
        product.setActive(true);
        product.setImageUrl("product5.png");

        //save entity
        Product savedObject = productRepository.save(product);

        //get saved entity
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateMethod() {
        Long id = 5L;
        Product product = productRepository.findById(id).get();

        product.setName("update product 1");

        productRepository.save(product);

    }

    @Test
    void saveAll() {
        //Create Product Category
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Books");
        productCategory.setCategoryDescription("Books Description");

        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("114ABCD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product1.png");
        product.setCategory(productCategory);
        productCategory.getProducts().add(product);

        // create product
        Product product3 = new Product();
        product3.setName("product 2");
        product3.setDescription("product 2 description");
        product3.setSku("115ABCDE");
        product3.setPrice(new BigDecimal(200));
        product3.setActive(true);
        product3.setImageUrl("product2.png");
        product3.setCategory(productCategory);
        productCategory.getProducts().add(product3);

        productCategoryRepository.save(productCategory);
        //productRepository.saveAll(List.of(product, product3));
    }

    @Test
    void findAll() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void deleteById() {
        productRepository.deleteById(5l);
    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }



}