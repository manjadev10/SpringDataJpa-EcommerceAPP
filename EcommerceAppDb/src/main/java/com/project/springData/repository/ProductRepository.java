package com.project.springData.repository;

import com.project.springData.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByName(String name);

    public List<Product> findByNameAndDescription(String name, String desc);

    public List<Product> findByNameOrDescription(String name, String desc);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceGreaterThanEqual(BigDecimal price);

    List<Product> findByNameContaining(String text);

    List<Product> findByCreatedOnBetween(LocalDateTime start, LocalDateTime end);

    List<Product> findByNameIn(List<String>  name);

    List<Product> findFirst2ByOrderByNameAsc();

    @Query("select p from Product p where p.name = ?1 or p.description = ?2 ")
    List<Product> findByNameOrDescriptionJPQLIndexParam(String name, String desc);

    @Query("select p from Product p where p.name = :name or p.description = :desc ")
    List<Product> findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,@Param("desc") String desc);

    @Query(value = "select * from products p where p.name = :name or p.description = :desc ", nativeQuery = true)
    List<Product> findByNameOrDescriptionSQLNamedParam(@Param("name") String name,@Param("desc") String desc);

    List<Product> findByPrice(BigDecimal price);

    @Query(nativeQuery = true)
    List<Product> findBySKU(@Param("sku") String sku);
}
