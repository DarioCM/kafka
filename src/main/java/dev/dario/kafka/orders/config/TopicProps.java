package dev.dario.kafka.orders.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.kafka")
public class TopicProps {

  private String topicOrders;
  private String topicOrdersJson;
  private int partitions = 3;
  private short replicationFactor = 1;

  public String getTopicOrders() {
    return topicOrders;
  }

  public void setTopicOrders(String topicOrders) {
    this.topicOrders = topicOrders;
  }

  public String getTopicOrdersJson() {
    return topicOrdersJson;
  }

  public void setTopicOrdersJson(String topicOrdersJson) {
    this.topicOrdersJson = topicOrdersJson;
  }

  public int getPartitions() {
    return partitions;
  }

  public void setPartitions(int partitions) {
    this.partitions = partitions;
  }

  public short getReplicationFactor() {
    return replicationFactor;
  }

  public void setReplicationFactor(short replicationFactor) {
    this.replicationFactor = replicationFactor;
  }
}
