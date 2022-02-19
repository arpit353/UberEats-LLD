package com.example.UberEats.Datastore;

import com.example.UberEats.Models.Bill.Bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillData {

    public static Map<String, Bill> billData = new HashMap<>();

    public static Map<String, List<Bill>> billDataByUser = new HashMap<>();

    public static Map<String, Bill> billDataByOrderId = new HashMap<>();

}