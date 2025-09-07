package com.likelion.seminar.product.service;


import com.likelion.seminar.product.entity.Product;
import com.likelion.seminar.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 1. JPA -> 가격으로 내림차순해서 상위 10개 제품 조회
    public List<Product> getTop10ExpensiveProducts() {
        return productRepository.findTop10ByOrderByPriceDesc();
    }

    // 2. JPQL -> 가격이 2000원 이하이고 재고가 많은 상품 5개 조회
    public List<Product> getCheapAndStockedTop5Products() {
        return productRepository.findCheapAndStockedTop5();
    }
}
