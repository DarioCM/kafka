package dev.dario.kafka.orders.dto;

import java.math.BigDecimal;

public record OrderItem(
    String sku,
    int quantity,
    BigDecimal unitPrice
) {

}
