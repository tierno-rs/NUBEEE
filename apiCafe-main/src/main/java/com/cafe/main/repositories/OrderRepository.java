package com.cafe.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.main.models.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {}
