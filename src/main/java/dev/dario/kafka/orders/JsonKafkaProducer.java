package dev.dario.kafka.orders;

import dev.dario.kafka.orders.config.TopicProps;
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
  private final TopicProps props;

  public JsonKafkaProducer(KafkaTemplate<String, OrderEventDTO> kafkaTemplate, TopicProps props) {
    this.kafkaTemplate = kafkaTemplate;
    this.props = props;
  }

  public void sendMessageEvent(OrderEventDTO data) {

    Message<OrderEventDTO> message = MessageBuilder
        .withPayload(data)
        .setHeader(KafkaHeaders.TOPIC, props.getTopicOrdersJson())
        .build();

    LOGGER.info(String.format("ORDER message sent -> %s ", data.toString()));
    kafkaTemplate.send(message);

  }
}
