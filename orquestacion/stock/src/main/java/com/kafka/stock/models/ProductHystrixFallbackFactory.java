package com.kafka.stock.models;

import org.springframework.stereotype.Component;

@Component
public class ProductHystrixFallbackFactory implements ProductClient{

    @Override
    public Product findItemById(String id) {
        Product product = Product.builder()
                .id("001")
                .name("Cerveza")
                .price(null)
                .stock(2)
                .build();
        return product;
    }
}