package com.example.UberEats.Services;

import com.example.UberEats.Models.Bill.Bill;
import com.example.UberEats.Models.Cart;
import com.example.UberEats.Models.Food.Food;
import com.example.UberEats.Models.Order.Order;
import com.example.UberEats.Models.Order.OrderStatus;
import com.example.UberEats.Models.Payment.Payment;
import com.example.UberEats.Models.Payment.PaymentStatus;
import com.example.UberEats.Models.Payment.PaymentType;
import com.example.UberEats.Services.Interfaces.PaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.UberEats.Datastore.PaymentData.paymentData;

@Service
public class PaymentService implements PaymentServiceInterface {

    private PricingService pricingService;
    private OrderService orderService;
    private CartService cartService;
    private FoodService foodService;

    @Autowired
    public PaymentService() {
        foodService = new FoodService();
        pricingService = new PricingService();
        orderService = new OrderService();
        cartService = new CartService(foodService, pricingService);
    }

    @Override
    public void addPayment(Payment payment) {
        paymentData.put(payment.getId(), payment);
    }

    public Payment getPayment(String paymentId) {
        return paymentData.get(paymentId);
    }

    @Override
    public void makePayment(String userId, String billId, PaymentType paymentType) {

        Bill bill = pricingService.getDetailedBill(billId);
        bill.setPaymentStatus(PaymentStatus.APPROVED);

        Cart cart = cartService.getUserCart(userId);

        List<Food> foodList = new ArrayList<>();
        for(String food : cart.getFoodMenu()) {
            Food foodItem = foodService.getFood(food);
            foodList.add(foodItem);
        }

        String paymentId = UUID.randomUUID().toString();

        Order order = Order.builder()
                .id(UUID.randomUUID().toString())
                .foodItemsList(foodList)
                .userId(userId)
                .restaurantId(cart.getRestaurantId())
                .paymentId(paymentId)
                .build();

        orderService.placeOrder(order);

        Payment payment = Payment.builder()
                .id(paymentId)
                .orderId(order.getId())
                .amount(bill.getTotalCost())
                .paymentStatus(PaymentStatus.APPROVED)
                .paymentType(paymentType)
                .build();

        addPayment(payment);
    }

}
