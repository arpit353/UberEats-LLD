package com.example.UberEats.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Cart {
    String userId;
    String restaurantId;
    List<String> foodMenu;
}
