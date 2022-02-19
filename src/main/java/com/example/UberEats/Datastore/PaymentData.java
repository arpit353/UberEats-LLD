package com.example.UberEats.Datastore;

import com.example.UberEats.Models.Payment.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentData {

    public static Map<String, Payment> paymentData = new HashMap<>();

    public static Map<String, Payment> paymentDataByOrderId = new HashMap<>();

}
