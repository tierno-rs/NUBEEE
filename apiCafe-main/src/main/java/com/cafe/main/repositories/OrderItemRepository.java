package com.cafe.main.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafe.main.models.OrderItemModel;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, Integer >{
    @Query("SELECT oi FROM OrderItemModel oi JOIN FETCH oi.order o JOIN FETCH o.user WHERE oi.id = :id")
    Optional<OrderItemModel> findByIdWithUser(@Param("id") int id);

    @Query("SELECT oi FROM OrderItemModel oi JOIN FETCH oi.order o JOIN FETCH o.user")
    List<OrderItemModel> findAllWithUser();
}
