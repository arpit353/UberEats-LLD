package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Bill.Bill;

public interface PricingServiceInterface {

    public void applyCouponCode(String billId, String CouponCode);

    public Bill getDetailedBill(String id);

}