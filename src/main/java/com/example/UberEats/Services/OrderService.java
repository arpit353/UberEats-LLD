package com.example.UberEats.Services;

import com.example.UberEats.Models.Order.Order;
import com.example.UberEats.Models.Order.OrderStatus;
import com.example.UberEats.Services.Interfaces.OrderServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.UberEats.Datastore.OrderData.*;

@Service
public class OrderService implements OrderServiceInterface {

    @Override
    public void placeOrder(Order order) {
        Order currentOrder = orderData.get(order.getId());
        currentOrder.setOrderStatus(OrderStatus.PLACED);
        orderData.put(order.getId(), order);
        List<Order> orders = orderDataByUserId.getOrDefault(order.getUserId(), new ArrayList<>());

        ArrayList<Order> ordersList = new ArrayList<>(orders);
        ordersList.add(order);

        orderDataByUserId.put(order.getUserId(), ordersList);

        orderDataByUserIdCurrent.put(order.getUserId(), order);
    }

    @Override
    public void cancelOrder(String orderId) {
        Order currentOrder = orderData.get(orderId);
        currentOrder.setOrderStatus(OrderStatus.CANCELED);
        orderData.put(orderId, currentOrder);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderData.get(orderId);
    }
}
