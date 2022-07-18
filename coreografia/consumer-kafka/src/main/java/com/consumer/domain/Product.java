package com.consumer.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Product {

	private String id;
	private String name;
	private Integer stock;
	private BigDecimal price;
}