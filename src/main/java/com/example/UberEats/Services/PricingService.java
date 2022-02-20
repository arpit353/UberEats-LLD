package com.example.UberEats.Services;

import com.example.UberEats.Models.Bill.Bill;
import com.example.UberEats.Services.Interfaces.PricingServiceInterface;
import org.springframework.stereotype.Service;

import static com.example.UberEats.Datastore.BillData.billData;
import static com.example.UberEats.Datastore.BillData.billDataByOrderId;

@Service
public class PricingService implements PricingServiceInterface {

    @Override
    public void applyCouponCode(String billId, String couponCode) {
        Bill bill = getDetailedBill(billId);
        bill.setCouponCode(couponCode);

        if(couponCode.equals("AK10")) {
            Double discount = bill.getTotalCost()/10.0;
            bill.setDiscount(discount);
            bill.setTotalCost(bill.getTotalCost() - discount);
        }

        if(couponCode.equals("AK100")) {
            Double discount = 100.0;
            bill.setDiscount(discount);
            bill.setTotalCost(bill.getTotalCost() - discount);
        }

        addBill(bill);

    }

    @Override
    public Bill getDetailedBill(String id) {
        return billData.get(id);
    }

    public void addBill(Bill bill) {
        billData.put(bill.getId(), bill);
    }

}
