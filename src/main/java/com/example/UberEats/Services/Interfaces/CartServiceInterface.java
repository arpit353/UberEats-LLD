package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Cart;

public interface CartServiceInterface {

    public void addToCart(String userId, String restaurantId, String foodId);

    public void removeFromCart(String userId, String restaurantId, String foodId);

    public Cart getUserCart(String userId);

    public String confirmCart(String userId);

}
