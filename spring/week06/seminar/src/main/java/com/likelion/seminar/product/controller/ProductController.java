package com.likelion.seminar.product.controller;


import com.likelion.seminar.product.entity.Product;
import com.likelion.seminar.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 1. JPA로 상위10개 조회
    @GetMapping("/jpa")
    public List<Product> getTop10ExpensiveProducts() {
        return productService.getTop10ExpensiveProducts();
    }

    // 2. JPQL로 가격이 2000원 이하이고 재고가 많은 상품 5개 조회
    @GetMapping("/jpql")
    public List<Product> getCheapAndStockedTop5Products() {
        return productService.getCheapAndStockedTop5Products();
    }
}
