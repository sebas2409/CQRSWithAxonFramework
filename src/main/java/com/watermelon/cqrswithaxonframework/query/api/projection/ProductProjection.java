package com.watermelon.cqrswithaxonframework.query.api.projection;

import com.watermelon.cqrswithaxonframework.command.api.model.ProductEntity;
import com.watermelon.cqrswithaxonframework.command.api.model.ProductRestModel;
import com.watermelon.cqrswithaxonframework.command.api.repository.ProductRepository;
import com.watermelon.cqrswithaxonframework.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjection {
    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery query){
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(productEntity -> ProductRestModel
                        .builder()
                        .name(productEntity.getName())
                        .quantity(productEntity.getQuantity())
                        .price(productEntity.getPrice())
                        .build()).toList();
    }
}
