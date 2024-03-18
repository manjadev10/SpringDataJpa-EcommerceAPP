package com.project.springData.repository;

import com.project.springData.entity.Product;
import com.project.springData.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory(){

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Books");
        productCategory.setCategoryDescription("Books Description");

        Product product1 = new Product();
        product1.setName("core java");
        product1.setPrice(new BigDecimal(10000));
        product1.setImageUrl("image1.png");
        product1.setSku("ABCD");
        product1.setActive(true);
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("advanced java");
        product2.setPrice(new BigDecimal(50000));
        product2.setImageUrl("image2.png");
        product2.setSku("ABCD");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
    }


    @Test
    @Transactional
    void fetchProductCategoryLazyTest(){
        ProductCategory productCategory = productCategoryRepository.findById(2l).get();
        System.out.println(productCategory);
        //System.out.println(productCategory.getProducts());
    }


}
