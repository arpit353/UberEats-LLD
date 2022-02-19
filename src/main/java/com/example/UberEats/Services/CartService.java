package com.example.UberEats.Services;

import com.example.UberEats.Models.Cart;
import com.example.UberEats.Services.Interfaces.CartServiceInterface;
import org.springframework.stereotype.Service;

import static com.example.UberEats.Datastore.CartData.cartData;

@Service
public class CartService implements CartServiceInterface {

    @Override
    public void addToCart(Cart cart) {
        cartData.put(cart.getUserId(), cart);
    }

    @Override
    public void removeFromCart(String cartId) {
        cartData.remove(cartId);
    }

}
