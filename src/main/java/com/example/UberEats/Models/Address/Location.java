package com.example.UberEats.Models.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
    Double latitude;
    Double longitude;
}
