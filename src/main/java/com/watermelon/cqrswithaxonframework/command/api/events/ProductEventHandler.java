package com.watermelon.cqrswithaxonframework.command.api.events;

import com.watermelon.cqrswithaxonframework.command.api.model.ProductEntity;
import com.watermelon.cqrswithaxonframework.command.api.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        var product = new ProductEntity();
        BeanUtils.copyProperties(event,product);
        productRepository.save(product);
    }
}
