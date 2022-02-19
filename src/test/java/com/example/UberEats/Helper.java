package com.example.UberEats;

import com.example.UberEats.Models.Address.Address;
import com.example.UberEats.Models.Address.Location;
import com.example.UberEats.Models.Restaurant;
import com.example.UberEats.Models.User;

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
            .name("Biriyani")
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

}
