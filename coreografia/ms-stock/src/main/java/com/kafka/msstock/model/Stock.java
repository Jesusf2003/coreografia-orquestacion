package com.kafka.msstock.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Stock {

    private int id;
    private int productId;
    private BigDecimal quantity;
}