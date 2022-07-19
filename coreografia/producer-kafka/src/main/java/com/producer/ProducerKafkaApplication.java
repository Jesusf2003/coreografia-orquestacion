package com.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProducerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerKafkaApplication.class, args);
	}
}