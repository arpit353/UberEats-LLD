package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.Bill.Bill;

public interface PricingServiceInterface {

    public void applyCouponCode();

    public Bill getDetailedBill(String id);

    public Bill getDetailedBillByOrderId(String id);

}