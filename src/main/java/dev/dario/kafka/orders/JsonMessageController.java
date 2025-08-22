package dev.dario.kafka.orders;

import dev.dario.kafka.orders.dto.OrderEventDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka/orders")
public class JsonMessageController {

  private JsonKafkaProducer kafkaProducer;

  public JsonMessageController(JsonKafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @PostMapping("/publish")
  public ResponseEntity<String> publish(@RequestBody OrderEventDTO order){
    kafkaProducer.sendMessageEvent(order);
    return ResponseEntity.ok("JSON order message sent to kafka orders topic");
  }


}
