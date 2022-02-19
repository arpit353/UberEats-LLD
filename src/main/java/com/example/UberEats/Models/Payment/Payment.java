package com.example.UberEats.Models.Payment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment {
    String id;
    String orderId;
    PaymentType paymentType;
    Double amount;
    String couponCode;
    PaymentStatus paymentStatus;
}
