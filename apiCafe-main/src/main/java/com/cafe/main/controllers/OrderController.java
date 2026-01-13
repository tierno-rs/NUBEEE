package com.cafe.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.main.models.OrderItemModel;
import com.cafe.main.models.OrderModel;
import com.cafe.main.services.OrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getAll")
    public List<OrderItemModel> getAll() {
        return orderService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> createOrder(@RequestBody OrderModel order) {
        for (OrderItemModel item : order.getItems()) {
            item.setOrder(order);
        }
        OrderModel savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/totalOrders")
    public long totalOrders(){
        return orderService.totalOrders();
    }

}
