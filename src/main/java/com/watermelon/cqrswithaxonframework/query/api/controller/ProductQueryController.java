package com.watermelon.cqrswithaxonframework.query.api.controller;

import com.watermelon.cqrswithaxonframework.command.api.model.ProductRestModel;
import com.watermelon.cqrswithaxonframework.query.api.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductQueryController {


    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        var productsQuery = new GetProductsQuery();

        return queryGateway.query(productsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();

    }
}
