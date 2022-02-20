package com.example.UberEats.Controller;

import com.example.UberEats.Models.Order.Order;
import com.example.UberEats.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order getOrder(String orderId) {
        return orderService.getOrder(orderId);
    }

    public void cancelOrder(String orderId) {
        orderService.cancelOrder(orderId);
    }

    public Order getOrderByOrderId(String orderId) {
        return orderService.getOrder(orderId);
    }

    public Order getOrderByUserId(String userId) {
        return orderService.getOrderByUserId(userId);
    }

}
