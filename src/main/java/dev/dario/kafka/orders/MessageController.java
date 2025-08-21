package dev.dario.kafka.orders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka/orders")
public class MessageController {

  private final KafkaProducer kafkaProducer; //this is a service

  public MessageController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  //..:8085//api/v1/kafka/orders/publish?message=...
  @GetMapping("/publish")
  public ResponseEntity<String> publish(@RequestParam("message") String message) {
    kafkaProducer.sendOrderMessage(message);
    return ResponseEntity.ok("Order message sent");
  }

}
