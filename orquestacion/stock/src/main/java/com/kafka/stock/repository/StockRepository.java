package com.kafka.stock.repository;

import com.kafka.stock.models.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends MongoRepository<Stock, Long> {

    Optional<Stock> findByProductId(String productId);
}