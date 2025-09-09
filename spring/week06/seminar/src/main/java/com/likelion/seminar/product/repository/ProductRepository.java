package com.likelion.seminar.product.repository;

import com.likelion.seminar.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 1번 과제 -> JPA
    List<Product> findTop10ByOrderByPriceDesc();

    // 2번 과제 -> JPQL
  //  @Query("SELECT p FROM Product p WHERE p.price <= 2000 ORDER BY p.stock DESC")
  //  List<Product> findCheapAndStockedTop5();


    @Query(value = "SELECT * FROM product WHERE price <= :price ORDER BY stock DESC LIMIT 5", nativeQuery = true)
    List<Product> findCheapAndStockedTop5(@Param("price") int price);

}
