package com.example.UberEats.Controller;

import com.example.UberEats.Models.Payment.Payment;
import com.example.UberEats.Models.Payment.PaymentType;
import com.example.UberEats.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(String userId, String billId, PaymentType paymentType) {
        paymentService.makePayment(userId, billId, paymentType);
    }

    public Payment getPayment(String paymentId) {
        return paymentService.getPayment(paymentId);
    }

}
