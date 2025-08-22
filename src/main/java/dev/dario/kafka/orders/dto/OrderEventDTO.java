package dev.dario.kafka.orders.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderEventDTO(
    String orderId,
    String userId,
    List<OrderItem> items,
    OrderStatus status,
    BigDecimal total,
    Instant createdAt
) {

}
