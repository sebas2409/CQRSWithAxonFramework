package com.watermelon.cqrswithaxonframework.command.api.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class ProductEntity {

    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
