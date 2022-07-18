package com.product.application;

import java.util.List;

import com.product.domain.*;

import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findItemById(String id) {
		return productRepository.findItemById(id);
	}

	public Product create(Product product) {
		System.out.println(product.toString());
		return productRepository.create(product);
	}

	public ResponseEntity<?> update(Product product) {
		productRepository.update(product);
		return new ResponseEntity<String>("Product update.", HttpStatus.CREATED);
	}

	public ResponseEntity<?> delete(String id) {
		productRepository.delete(id);
		return new ResponseEntity<String>("Product delete.", HttpStatus.CREATED);
	}
}