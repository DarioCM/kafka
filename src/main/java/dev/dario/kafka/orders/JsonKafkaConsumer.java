package dev.dario.kafka.orders;

import dev.dario.kafka.orders.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

  @KafkaListener(topics = "${app.kafka.topic-orders-json}", groupId = "consumer-group")
  public void consume(OrderEventDTO order) {
    LOGGER.info(String.format("JSON Order message recieved -> %s ", order.toString()));
  }

}
