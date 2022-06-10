package com.kafka.stock.controller;

import com.kafka.stock.models.Stock;
import com.kafka.stock.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Stock> findStockByProductId(@PathVariable("id") String id) {
        log.info("Buscando el stock del producto por Id: {}", id);
        Optional<Stock> iOptional = stockRepository.findByProductId(id);
        if (iOptional.isPresent()) {
            return new ResponseEntity<>(iOptional.get(), HttpStatus.OK);
        }

        log.info("No se pudo encontrar el producto: {}", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getStock() {
        log.info("Trayedo todo el inventario");
        return new ResponseEntity<>(stockRepository.findAll(), HttpStatus.OK);
    }
}