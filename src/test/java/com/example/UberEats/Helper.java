package com.example.UberEats;

import com.example.UberEats.Models.Address.Address;
import com.example.UberEats.Models.Address.Location;
import com.example.UberEats.Models.Food.Food;
import com.example.UberEats.Models.Food.FoodType;
import com.example.UberEats.Models.Restaurant;
import com.example.UberEats.Models.User;

import java.util.List;

public class Helper {

    public static Location location = com.example.UberEats.Models.Address.Location.builder()
            .latitude(20.2)
            .longitude(50.5)
            .build();

    public static Address address = Address.builder()
            .city("Delhi")
            .zipcode("242001")
            .streetAddress("Sarojni Nagar")
            .location(location)
            .build();

    public static User user = User.builder()
            .id("USER1")
            .phoneNumber("123456789")
            .name("Biryani")
            .address(address)
            .build();

    public static Restaurant restaurant = Restaurant.builder()
            .id("REST1")
            .description("Hello")
            .imageUrl("imageUrl")
            .phone("123456789")
            .address(address)
            .name("Dhaba")
            .build();

    public static Food food1 = Food.builder()
            .foodType(FoodType.VEG)
            .id("FOOD1")
            .name("Biryani")
            .price(300.00)
            .build();

    public static Food food2 = Food.builder()
            .foodType(FoodType.NON_VEG)
            .id("FOOD2")
            .name("Khichdi")
            .price(300.00)
            .build();

    public static List<Food> foodList = List.of(food1, food2);


}
