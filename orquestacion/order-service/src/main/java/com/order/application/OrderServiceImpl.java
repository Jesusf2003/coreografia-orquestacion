package com.order.application;

import java.util.List;
import java.util.Optional;

import com.order.domain.Order;
import com.order.domain.OrderRepository;
import com.order.domain.Product;
import com.order.domain.ProductClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Qualifier("com.order.domain.ProductClient")
	@Autowired
	ProductClient cliProd;

	@Override
	public List<Order> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Order> findOrderById(String id) {
		return this.repository.findById(id);
	}

	@Override
	public Order create(Order order) {
		System.out.println(order.toString());
		return this.repository.save(order);
	}

	@Override
	public void update(Order order) {
		this.repository.save(order);
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);
	}
	
	@Override
	public Product findItemById(String id) {
		
		Product optProduct = cliProd.findItemById(id);
		
		if (optProduct == null) {
			System.out.println("No se pudo encontrar el producto");
			return null;
		}
		
		return optProduct;
	}
}