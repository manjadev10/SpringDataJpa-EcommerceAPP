package com.project.springData.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.project.springData.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void PaginationOnly(){

        int pageNo = 0;
        int pageSize = 3;

        Pageable pageable = PageRequest.of(pageNo,pageSize);

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach( p ->
        {
            System.out.println(p.getName());
        });

        int totalPages = page.getTotalPages();

        System.out.println("total page -> "+totalPages);

        long totalElements = page.getTotalElements();

        System.out.println("totalElements -> "+totalElements);

        int numberOfelements = page.getNumberOfElements();

        System.out.println("Number of Elements -> "+numberOfelements);

        int size = page.getSize();

        System.out.println("Size "+size);

        boolean isLast = page.isLast();

        System.out.println("IS Last? : "+isLast);


    }

    @Test
    void sortingTest() {

        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("pirce").ascending()
                    : Sort.by("price").descending();

        List<Product> products = productRepository.findAll(Sort.by("price").descending());

        products.forEach(p ->
        {
            System.out.println(p);
        });

     }

     @Test
     void sortByMultipleFields(){

        Sort sortByName = Sort.by("price").descending();
        Sort sortByDesc = Sort.by("name").ascending();

        Sort groupSorts = sortByName.and(sortByDesc);

         List<Product> products = productRepository.findAll(Sort.by("price").descending());

         products.forEach(p ->
         {
             System.out.println(p);
         });
     }

     @Test
     void pagingAndSorting(){

        Pageable pageable = PageRequest.of(1,2,Sort.by("price"));

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.stream().forEach(System.out::println);

         int totalPages = page.getTotalPages();
         System.out.println("total page -> "+totalPages);

         long totalElements = page.getTotalElements();
         System.out.println("totalElements -> "+totalElements);

         int numberOfelements = page.getNumberOfElements();
         System.out.println("Number of Elements -> "+numberOfelements);

         int size = page.getSize();
         System.out.println("Size "+size);

         boolean isLast = page.isLast();
         System.out.println("IS Last? : "+isLast);

         boolean isFirst = page.isFirst();
         System.out.println("IS First? : "+isFirst);
     }


    }
