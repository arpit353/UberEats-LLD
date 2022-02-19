package com.example.UberEats.Models.Food;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FoodMenu {
    String restaurantId;
    List<Food> foodItemsList;
}
