package com.example.UberEats.Services;

import com.example.UberEats.Models.Bill.Bill;
import com.example.UberEats.Models.Cart;
import com.example.UberEats.Models.Food.Food;
import com.example.UberEats.Services.Interfaces.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.example.UberEats.Datastore.CartData.cartData;

@Service
public class CartService implements CartServiceInterface {

    private FoodService foodService;

    private PricingService pricingService;

    @Autowired
    public CartService(FoodService foodService, PricingService pricingService) {
        this.foodService = foodService;
        this.pricingService = pricingService;
    }

    @Override
    public void addToCart(String userId, String restaurantId, String foodId) {

        Cart cart = getUserCart(userId);

        if(cart.getRestaurantId() != null && cart.getRestaurantId().equals(restaurantId)) {
            var foodMenu =  new ArrayList<>(cart.getFoodMenu());
            foodMenu.add(foodId);
            cart.setFoodMenu(foodMenu);
        } else {
            cart.setUserId(userId);
            cart.setRestaurantId(restaurantId);
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

    @Override
    public String confirmCart(String userId) {

        Cart cart = getUserCart(userId);

        Double amount = 0.0;

        for(var foodId : cart.getFoodMenu()) {
            Food food = foodService.getFood(foodId);
            amount += food.getPrice();
        }

        Bill bill = Bill.builder()
                .id(UUID.randomUUID().toString())
                .totalCost(amount)
                .userId(userId)
                .tax(amount*18/100)
                .build();

        pricingService.addBill(bill);

        return bill.getId();

    }

}
