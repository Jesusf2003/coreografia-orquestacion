package com.kafka.msstock.consumer;

import com.kafka.msstock.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "ni14yn7m-stock", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Stock stock) {
        log.info("Mensaje recibido: "+ stock);
    }
}