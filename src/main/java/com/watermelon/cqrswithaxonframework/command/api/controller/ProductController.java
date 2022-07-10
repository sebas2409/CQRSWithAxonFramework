package com.watermelon.cqrswithaxonframework.command.api.controller;


import com.watermelon.cqrswithaxonframework.command.api.commands.CreateProductCommand;
import com.watermelon.cqrswithaxonframework.command.api.model.ProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    private final CommandGateway commandGateway;

    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductRestModel product){

        var createCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        return commandGateway.sendAndWait(createCommand);
    }
}
