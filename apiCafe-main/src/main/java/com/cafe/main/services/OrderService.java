package com.cafe.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.main.models.OrderItemModel;
import com.cafe.main.models.OrderModel;
import com.cafe.main.repositories.OrderItemRepository;
import com.cafe.main.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderModel> getOrders(){
        return orderRepository.findAll();
    }

    public List<OrderItemModel> getAll(){
        List<OrderItemModel> items = orderItemRepository.findAll();
        items.forEach(item -> {
            if(item.getOrder() != null && item.getOrder().getUser() != null) {
                item.getOrder().getUser().getUsername();
            }
        });
        
        return items;
    }

    public OrderModel getOrderById(int id){
        return orderRepository.findById(id).orElse(null);
    }

    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);
    }
    
    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

    public long totalOrders(){
        return orderItemRepository.count();
    }


}
