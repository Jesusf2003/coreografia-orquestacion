package com.product.infraestructura;

import java.util.List;

import com.product.domain.Product;
import com.product.domain.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Repository
public class ProductImpl implements ProductRepository {

	@Autowired
	private final MongoOperations mongoOperations;

	protected ProductImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<Product> findAll() {
		return this.mongoOperations.findAll(Product.class);
	}

	@Override
	public Product findItemById(String id) {
		return this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Product.class);
	}

	@Override
	public Product create(Product product) {
		System.out.println(product.toString());
		return this.mongoOperations.save(product);
	}

	@Override
	public void update(Product product) {
		this.mongoOperations.save(product);
	}

	@Override
	public void delete(String id) {
		this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Product.class);
	}
}