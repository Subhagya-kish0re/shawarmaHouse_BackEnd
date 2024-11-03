package com.example.shawarmahouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTokenRequest {

    private String phoneNumber;
    private double totalAmount;
    private boolean useTokens;

}
