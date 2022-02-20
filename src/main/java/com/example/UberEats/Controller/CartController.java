package com.example.UberEats.Controller;

import com.example.UberEats.Models.Cart;
import com.example.UberEats.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public void addToCart(String userId, String restaurantId, String foodId) {
        cartService.addToCart(userId, restaurantId, foodId);
    }

    public void removeFromCart(String userId, String restaurantId, String foodId) {
        cartService.removeFromCart(userId, restaurantId, foodId);
    }

    public Cart getCartFromUserId(String userId) {
        return cartService.getUserCart(userId);
    }

    public String confirmCart(String userId) {
        return cartService.confirmCart(userId);
    }

}
