package com.example.UberEats.Models.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    String streetAddress;
    String city;
    String zipcode;
    Location location;
}
