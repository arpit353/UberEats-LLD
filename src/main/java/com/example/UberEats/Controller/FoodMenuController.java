package com.example.UberEats.Controller;

import com.example.UberEats.Models.Food.Food;
import com.example.UberEats.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FoodMenuController {

    private FoodService foodService;

    @Autowired
    public FoodMenuController(FoodService foodService) {
        this.foodService = foodService;
    }

    public List<Food> getFoodsForRestaurant(String restaurantId) {
        return foodService.getFoodMenu(restaurantId);
    }

    public void addFoodMenu(String restaurantId, List<Food> foodList) {
        foodService.addFoodMenu(restaurantId, foodList);
    }

    public void addFood(Food food) {
        foodService.addFood(food);
    }

}
