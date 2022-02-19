package com.example.UberEats;

import com.example.UberEats.Controller.FoodMenuController;
import com.example.UberEats.Controller.RestaurantController;
import com.example.UberEats.Controller.UserController;
import com.example.UberEats.Services.FoodService;
import com.example.UberEats.Services.RestaurantService;
import com.example.UberEats.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.UberEats.Helper.*;

@SpringBootTest
class UberEatsApplicationTests {

	UserController userController;
	RestaurantController restaurantController;
	FoodMenuController foodMenuController;

	@BeforeEach
	void setup() {
		UserService userService = new UserService();
		FoodService foodService = new FoodService();
		RestaurantService restaurantService = new RestaurantService(userService);

		userController = new UserController(userService);
		restaurantController = new RestaurantController(restaurantService);
		foodMenuController = new FoodMenuController(foodService);
	}

	@Test
	void UserFlowTest() {

		userController.addUser(user);
		System.out.println(userController.getUser("USER1"));

		restaurantController.addRestaurant(restaurant);
		System.out.println(restaurantController.getRestaurantForUser(user.getId()));

		foodMenuController.addFoodMenu(restaurant.getId(), foodList);
		System.out.println(foodMenuController.getFoodsForRestaurant(restaurant.getId()));

	}
}
