package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Payment.Payment;
import com.example.UberEats.Models.Payment.PaymentType;

public interface PaymentServiceInterface {

    public void makePayment(String userId, String payment, PaymentType paymentType);

    public void addPayment(Payment payment);

}
