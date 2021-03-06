package com.example.UberEats.Models.Food;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Food {
    String id;
    String name;
    Double price;
    FoodType foodType;
}
