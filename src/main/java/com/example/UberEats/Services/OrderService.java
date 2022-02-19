package com.example.UberEats.Services;

import com.example.UberEats.Models.Order.Order;
import com.example.UberEats.Models.Order.OrderStatus;
import com.example.UberEats.Services.Interfaces.OrderServiceInterface;
import org.springframework.stereotype.Service;

import static com.example.UberEats.Datastore.OrderData.orderData;

@Service
public class OrderService implements OrderServiceInterface {

    @Override
    public void placeOrder(Order order) {
        Order currentOrder = orderData.get(order.getId());
        currentOrder.setOrderStatus(OrderStatus.PLACED);
        orderData.put(order.getId(), order);
    }

    @Override
    public void cancelOrder(Order order) {
        Order currentOrder = orderData.get(order.getId());
        currentOrder.setOrderStatus(OrderStatus.CANCELED);
        orderData.put(order.getId(), order);
    }

    @Override
    public void getOrder(String orderId) {
        orderData.get(orderId);
    }
}
