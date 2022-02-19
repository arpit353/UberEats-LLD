package com.example.UberEats.Models.Bill;

import com.example.UberEats.Models.Payment.PaymentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bill {
    String id;
    String userId;
    Double totalCost;
    Double discount;
    Double tax;
    CouponCode couponCode;
    PaymentType paymentType;
}
