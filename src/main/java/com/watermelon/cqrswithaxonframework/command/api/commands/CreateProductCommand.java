package com.watermelon.cqrswithaxonframework.command.api.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
