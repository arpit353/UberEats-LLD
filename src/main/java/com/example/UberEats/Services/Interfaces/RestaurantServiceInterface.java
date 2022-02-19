package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Restaurant;

import java.util.List;

public interface RestaurantServiceInterface {

    public void registerRestaurant(Restaurant restaurant);

    public Restaurant getRestaurant(String restaurantId);

    public List<Restaurant> getRestaurantsByUserCity(String userId);

    public List<Restaurant> getAllRestaurants();

    public void updateRestaurant(Restaurant restaurant);

    public void deleteRestaurant(String restaurantId);

}
