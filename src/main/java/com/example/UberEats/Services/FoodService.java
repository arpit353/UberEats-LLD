package com.example.UberEats.Services;

import com.example.UberEats.Models.Food.Food;
import com.example.UberEats.Services.Interfaces.FoodServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.UberEats.Datastore.FoodData.foodData;
import static com.example.UberEats.Datastore.FoodMenuData.foodMenuData;

@Service
public class FoodService implements FoodServiceInterface {

    @Override
    public void addFood(Food food) {
        foodData.put(food.getId(), food);
    }

    public Food getFood(String foodId) {
        return foodData.get(foodId);
    }

    @Override
    public void addFoodMenu(String restaurantId, List<Food> foodList) {
        foodMenuData.put(restaurantId, foodList);
    }

    @Override
    public List<Food> getFoodMenu(String restaurantId) {
        return foodMenuData.get(restaurantId);
    }
}
