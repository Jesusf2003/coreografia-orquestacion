package com.producer.producer;

import lombok.extern.slf4j.Slf4j;

import com.producer.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;

	public void sendCustomMessage(Product product, String topicName) {
		log.info("Sending Json Serializer : {}", product);
		Message<Product> message = MessageBuilder.withPayload(product).setHeader(KafkaHeaders.TOPIC, topicName).build();
		kafkaTemplate.send(message);
	}
}