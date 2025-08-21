package dev.dario.kafka.orders;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(kafkaConsumer.class);

  @KafkaListener(topics = "orders", groupId = "consumer-group")
  public void consumeOrders(String order){
    LOGGER.info(String.format("Order received -> %s ", order));
  }

}
