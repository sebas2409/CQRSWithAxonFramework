package com.watermelon.cqrswithaxonframework.command.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductRestModel {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
