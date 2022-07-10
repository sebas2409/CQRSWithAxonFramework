package com.watermelon.cqrswithaxonframework.command.api.aggregate;

import com.watermelon.cqrswithaxonframework.command.api.commands.CreateProductCommand;
import com.watermelon.cqrswithaxonframework.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate { //this is the same as product handler

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        var createdEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(command,createdEvent);
        AggregateLifecycle.apply(createdEvent);

    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.productId = event.getProductId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
    }


}
