package com.order.rest;

import java.util.List;
import java.util.Optional;

import com.order.application.OrderService;
import com.order.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping
	public List<Order> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Order> findOrderById(@PathVariable String id) {
		return this.service.findOrderById(id);
	}

	@PostMapping
	public Order save(@RequestBody Order order) {

		Product product = service.findItemById(order.getProduct().getId());

		System.out.println(product.toString());

		order.setProduct(product);

		return service.create(order);
	}

	@GetMapping("/product/id/{id}")
	private Product traerProduct(@PathVariable("id") String id) {
		return service.findItemById(id);
	}

	@PutMapping
	public void update(@RequestBody Order order) {
		this.service.update(order);
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
}