package com.example.UberEats.Services;

import com.example.UberEats.Models.Restaurant;
import com.example.UberEats.Models.User;
import com.example.UberEats.Services.Interfaces.RestaurantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.UberEats.Datastore.RestaurantData.restaurantData;

@Service
public class RestaurantService implements RestaurantServiceInterface {

    private UserService userService;

    @Autowired
    public RestaurantService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        restaurantData.put(restaurant.getId(), restaurant);
    }

    @Override
    public Restaurant getRestaurant(String restaurantId) {
        return restaurantData.get(restaurantId);
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        restaurantData.remove(restaurantId);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantData.put(restaurant.getId(), restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantData.values().stream().toList();
    }

    @Override
    public List<Restaurant> getRestaurantsByUserCity(String userId) {
        List<Restaurant> restaurants = new ArrayList<>();
        User user = userService.getUser(userId);
        for(var restaurant : restaurantData.values()) {
            if(restaurant.getAddress().getCity().equals(user.getAddress().getCity())) {
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }
}
