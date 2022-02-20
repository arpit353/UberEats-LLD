package com.example.UberEats.Controller;

import com.example.UberEats.Models.Bill.Bill;
import com.example.UberEats.Services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;

public class PricingController {

    private PricingService pricingService;

    @Autowired
    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public Bill getBill(String billId) {
        return pricingService.getDetailedBill(billId);
    }

    public void applyCoupon(String billId, String couponId) {
        pricingService.applyCouponCode(billId, couponId);
    }

}
