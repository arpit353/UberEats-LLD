package com.example.UberEats;

import com.example.UberEats.Controller.*;
import com.example.UberEats.Models.Bill.Bill;
import com.example.UberEats.Models.Order.Order;
import com.example.UberEats.Models.Payment.Payment;
import com.example.UberEats.Models.Payment.PaymentType;
import com.example.UberEats.Services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.UberEats.Helper.*;

@SpringBootTest
class UberEatsApplicationTests {

	UserController userController;
	RestaurantController restaurantController;
	FoodMenuController foodMenuController;
	CartController cartController;
	PricingController pricingController;
	PaymentController paymentController;
	OrderController orderController;

	@BeforeEach
	void setup() {
		UserService userService = new UserService();
		FoodService foodService = new FoodService();
		PricingService pricingService = new PricingService();
		CartService cartService = new CartService(foodService, pricingService);
		RestaurantService restaurantService = new RestaurantService(userService);
		PaymentService paymentService = new PaymentService();
		OrderService orderService = new OrderService();

		userController = new UserController(userService);
		restaurantController = new RestaurantController(restaurantService);
		foodMenuController = new FoodMenuController(foodService);
		cartController = new CartController(cartService);
		pricingController = new PricingController(pricingService);
		paymentController = new PaymentController(paymentService);
		orderController = new OrderController(orderService);
	}

	@Test
	void UserFlowTest() {

		userController.addUser(user);
		System.out.println(userController.getUser("USER1"));

		restaurantController.addRestaurant(restaurant);
		System.out.println(restaurantController.getRestaurantForUser(user.getId()));

		foodMenuController.addFoodMenu(restaurant.getId(), foodList);
		var foodList = foodMenuController.getFoodsForRestaurant(restaurant.getId());
		System.out.println(foodList);

		foodMenuController.addFood(food1);
		foodMenuController.addFood(food2);

		cartController.addToCart(user.getId(), restaurant.getId(), foodList.get(0).getId());
		cartController.addToCart(user.getId(), restaurant.getId(), foodList.get(1).getId());

		var cart = cartController.getCartFromUserId(user.getId());
		System.out.println(cart);

		String billId = cartController.confirmCart(user.getId());

		Bill bill = pricingController.getBill(billId);
		System.out.println(bill);

		pricingController.applyCoupon(billId, "AK10");

		bill = pricingController.getBill(billId);
		System.out.println(bill);

		paymentController.makePayment(user.getId(), billId, PaymentType.CASH_ON_DELIVERY);

		Order order = orderController.getOrderByUserId(user.getId());

		Payment payment = paymentController.getPayment(order.getPaymentId());

		System.out.println(order);
		System.out.println(payment);

	}
}
