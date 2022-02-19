package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Food.Food;

import java.util.List;

public interface FoodServiceInterface {

    public void addFood(Food food);

    public void addFoodMenu(String restaurantId, List<Food> foodList);

    public List<Food> getFoodMenu(String restaurantId);

}
