package com.example.UberEats.Services;

import com.example.UberEats.Models.Bill.Bill;
import com.example.UberEats.Services.Interfaces.PricingServiceInterface;
import org.springframework.stereotype.Service;

import static com.example.UberEats.Datastore.BillData.billData;
import static com.example.UberEats.Datastore.BillData.billDataByOrderId;

@Service
public class PricingService implements PricingServiceInterface {

    @Override
    public void applyCouponCode() {

    }

    @Override
    public Bill getDetailedBill(String id) {
        return billData.get(id);
    }

    @Override
    public Bill getDetailedBillByOrderId(String id) {
        return billDataByOrderId.get(id);
    }

}
