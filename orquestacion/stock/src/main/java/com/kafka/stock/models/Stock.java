package com.kafka.stock.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "stock")
public class Stock {

    @Id
    private Long id;
    private Integer productId;
    private Integer avaliableQuantity = 0;
}