package com.kafka.stock.models;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private String id;
    private String name;
    private Integer stock;
    private BigDecimal price;
}