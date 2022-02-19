package com.example.UberEats.Services;

import com.example.UberEats.Models.Payment.Payment;
import com.example.UberEats.Services.Interfaces.PaymentServiceInterface;
import org.springframework.stereotype.Service;

import static com.example.UberEats.Datastore.PaymentData.paymentData;

@Service
public class PaymentService implements PaymentServiceInterface {

    @Override
    public void makePayment(Payment payment) {
        paymentData.put(payment.getId(), payment);
    }
}
