package com.example.shawarmahouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsInfo {
    private String phoneNumber;
    private double totalAmount;
    private double tokens;
}
