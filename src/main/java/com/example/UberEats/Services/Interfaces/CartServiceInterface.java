package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Cart;

public interface CartServiceInterface {

    public void addToCart(Cart cart);

    public void removeFromCart(String cartId);

}
