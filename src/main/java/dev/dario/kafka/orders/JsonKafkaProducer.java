package dev.dario.kafka.orders;

import dev.dario.kafka.orders.dto.OrderEventDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

  private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

  public JsonKafkaProducer(KafkaTemplate<String, OrderEventDTO> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessageEvent(OrderEventDTO data) {

    Message<OrderEventDTO> message = MessageBuilder
        .withPayload(data)
        .setHeader(KafkaHeaders.TOPIC, "orders")
        .build();

    LOGGER.info(String.format("ORDER message sent -> %s ", data.toString()));
    kafkaTemplate.send(message);

  }
}
