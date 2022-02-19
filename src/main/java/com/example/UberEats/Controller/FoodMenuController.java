package com.example.UberEats.Controller;

import com.example.UberEats.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

public class FoodMenuController {

    private FoodService foodService;

    @Autowired
    public FoodMenuController(FoodService foodService) {
        this.foodService = foodService;
    }

}
