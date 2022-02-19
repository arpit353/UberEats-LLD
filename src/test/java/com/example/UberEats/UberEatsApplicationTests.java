package com.example.UberEats;

import com.example.UberEats.Controller.RestaurantController;
import com.example.UberEats.Controller.UserController;
import com.example.UberEats.Models.Address.Address;
import com.example.UberEats.Models.Address.Location;
import com.example.UberEats.Models.Restaurant;
import com.example.UberEats.Models.User;
import com.example.UberEats.Services.RestaurantService;
import com.example.UberEats.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.UberEats.Helper.restaurant;
import static com.example.UberEats.Helper.user;

@SpringBootTest
class UberEatsApplicationTests {

	UserController userController;
	RestaurantController restaurantController;

	@BeforeEach
	void setup() {
		UserService userService = new UserService();
		RestaurantService restaurantService = new RestaurantService(userService);
		userController = new UserController(userService);
		restaurantController = new RestaurantController(restaurantService);
	}

	@Test
	void UserFlowTest() {

		userController.addUser(user);
		System.out.println(userController.getUser("USER1"));

		restaurantController.addRestaurant(restaurant);
		System.out.println(restaurantController.getRestaurantForUser(user.getId()));

	}

}
