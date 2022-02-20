package com.example.UberEats.Datastore;

import com.example.UberEats.Models.Order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderData {

    public static Map<String, Order> orderData = new HashMap<>();
    public static Map<String, List<Order>> orderDataByUserId = new HashMap<>();
    public static Map<String, Order> orderDataByUserIdCurrent = new HashMap<>();

}
