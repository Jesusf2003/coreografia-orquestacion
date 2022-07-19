package com.order.domain;

import org.springframework.stereotype.Component;

@Component
public class ProductHystrixFallbackFactory implements ProductClient {

	@Override
	public Product findItemById(String id) {
		Product product = new Product();
		return product.builder().id(id).name(product.getName()).price(product.getPrice()).stock(product.getStock()).price(product.getPrice()).build();
	}
}