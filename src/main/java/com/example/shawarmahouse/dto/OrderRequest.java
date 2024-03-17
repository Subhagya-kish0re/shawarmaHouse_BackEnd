package com.example.shawarmahouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    @JsonProperty(required = true)
//    @NotEmpty(message = "Name is mandatory")
    private String userId;

    private String userName;

    @JsonProperty(required = true)
//    @NotBlank(message = "Please provide a valid phone number")
    private HashMap<String,Integer> itemsWithQuantity;

    @JsonProperty(required = true)
    private int totalAmount;

}
