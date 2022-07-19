package com.order.domain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service", url = "http://localhost:9002", fallback = ProductHystrixFallbackFactory.class)
public interface ProductClient {

    @GetMapping(value = "/product/{id}")
    Product findItemById(@PathVariable("id") String id);
}