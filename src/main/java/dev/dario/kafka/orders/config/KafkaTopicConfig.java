package dev.dario.kafka.orders.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  private final TopicProps props;

  public KafkaTopicConfig(TopicProps props) {
    this.props = props;
  }

  @Bean
  public NewTopic ordersTopic() {
    return TopicBuilder.name(props.getTopicOrders())
        .partitions(props.getPartitions())
        .build();
  }

  @Bean
  public NewTopic ordersJSONTopic() {
    return TopicBuilder.name(props.getTopicOrdersJson())
        .partitions(props.getPartitions())
        .build();
  }


}
