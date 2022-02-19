package com.example.UberEats.Models;

import com.example.UberEats.Models.Address.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String id;
    String name;
    Address address;
    String phoneNumber;
}
