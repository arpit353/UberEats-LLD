package com.example.UberEats.Services;

import com.example.UberEats.Models.Cart;
import com.example.UberEats.Services.Interfaces.CartServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.UberEats.Datastore.CartData.cartData;

@Service
public class CartService implements CartServiceInterface {

    @Override
    public void addToCart(String userId, String restaurantId, String foodId) {

        Cart cart = getUserCart(userId);

        if(Objects.equals(cart.getRestaurantId(), restaurantId)) {
            cart.getFoodMenu().add(foodId);
        } else {
            cart.setFoodMenu(List.of(foodId));
        }

        cartData.put(userId, cart);
    }

    @Override
    public void removeFromCart(String userId, String restaurantId, String foodId) {
        Cart cart = getUserCart(userId);

        if(Objects.equals(cart.getRestaurantId(), restaurantId)) {
            cart.getFoodMenu().remove(foodId);
        } else {
            System.out.println("Wrong Data");
        }

        cartData.put(userId, cart);
    }

    @Override
    public Cart getUserCart(String userId) {
        return cartData.getOrDefault(userId, Cart.builder().build());
    }

}
