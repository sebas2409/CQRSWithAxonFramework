package com.watermelon.cqrswithaxonframework.command.api.repository;

import com.watermelon.cqrswithaxonframework.command.api.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
}
