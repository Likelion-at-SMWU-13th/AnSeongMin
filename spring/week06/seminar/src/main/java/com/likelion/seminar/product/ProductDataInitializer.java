package com.likelion.seminar.product;

import com.likelion.seminar.product.entity.Product;
import com.likelion.seminar.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) { // DB 비어있을 때만 실행
            productRepository.save(new Product("연필", 500, 200));
            productRepository.save(new Product("샤프펜슬", 2000, 150));
            productRepository.save(new Product("모나미펜", 2000, 150));
            productRepository.save(new Product("펜", 2000, 230));
            productRepository.save(new Product("샤프", 2000, 182));
            productRepository.save(new Product("펜홀더", 2000, 392));
            productRepository.save(new Product("지우개", 800, 300));
            productRepository.save(new Product("볼펜", 1000, 500));
            productRepository.save(new Product("형광펜", 1200, 250));
            productRepository.save(new Product("노트", 1500, 400));
        }
    }
}
