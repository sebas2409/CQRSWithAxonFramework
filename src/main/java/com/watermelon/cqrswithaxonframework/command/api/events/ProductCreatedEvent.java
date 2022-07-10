package com.watermelon.cqrswithaxonframework.command.api.events;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreatedEvent {

    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
