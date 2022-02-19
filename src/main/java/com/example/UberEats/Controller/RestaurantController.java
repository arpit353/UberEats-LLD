package com.example.UberEats.Controller;

import com.example.UberEats.Models.Restaurant;
import com.example.UberEats.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public void addRestaurant(final Restaurant restaurant) {
        restaurantService.registerRestaurant(restaurant);
    }

    public void deleteRestaurant(final String restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }

    public void updateRestaurant(final Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
    }

    public Restaurant getRestaurant(final String restaurantId) {
        return restaurantService.getRestaurant(restaurantId);
    }

    public List<Restaurant> getRestaurantForUser(String userId) {
        return restaurantService.getRestaurantsByUserCity(userId);
    }

}