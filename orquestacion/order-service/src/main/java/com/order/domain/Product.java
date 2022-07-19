package com.order.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	private String id;
	private String name;
	private Integer stock;
	private BigDecimal price;
}