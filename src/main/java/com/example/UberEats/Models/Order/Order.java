package com.example.UberEats.Models.Order;

import com.example.UberEats.Models.Food.Food;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    String id;
    String userId;
    String restaurantId;
    List<Food> foodItemsList;
    OrderStatus orderStatus;
    String paymentId;
}
