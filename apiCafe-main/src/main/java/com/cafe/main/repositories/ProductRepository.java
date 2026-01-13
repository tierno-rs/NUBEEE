package com.cafe.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.main.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {}
