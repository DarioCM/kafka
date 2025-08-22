package dev.dario.kafka.orders;

import dev.dario.kafka.orders.config.TopicProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

  private KafkaTemplate<String, String> kafkaTemplate;
  private final TopicProps props;

  public KafkaProducer(TopicProps props, KafkaTemplate<String, String> kafkaTemplate) {
    this.props = props;
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendOrderMessage(String order) {
    LOGGER.info(String.format("Order sent %s", order));
    kafkaTemplate.send(props.getTopicOrders(), order);
  }


}
