package com.product.rest;

import java.util.List;

import com.product.application.ProductService;
import com.product.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	ProductRepository productRepository;
	@Autowired
	ProductService productService = new ProductService(productRepository);

	@GetMapping("/listProducts")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Product findItemById(@PathVariable String id) {
		return productService.findItemById(id);
	}

	@PostMapping
	public Product saveStudent(@RequestBody Product product) {
		return productService.create(product);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product product) {
		return productService.update(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return productService.delete(id);
	}
}