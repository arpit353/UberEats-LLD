package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Order.Order;

public interface OrderServiceInterface {

    public void placeOrder(Order order);

    public void cancelOrder(Order order);

    public void getOrder(String orderId);

}
