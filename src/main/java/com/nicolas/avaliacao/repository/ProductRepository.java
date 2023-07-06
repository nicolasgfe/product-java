package com.nicolas.avaliacao.repository;

import com.nicolas.avaliacao.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
