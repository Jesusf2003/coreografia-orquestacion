package com.order.application;

import java.util.List;
import java.util.Optional;

import com.order.domain.Order;
import com.order.domain.Product;

public interface OrderService {

	List<Order> findAll();

	Optional<Order> findOrderById(String id);

	Order create(Order order);

	void update(Order order);

	void delete(String id);
	
	Product findItemById(String id);
}