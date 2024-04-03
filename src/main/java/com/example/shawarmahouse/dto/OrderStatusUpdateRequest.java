package com.example.shawarmahouse.dto;

import com.example.shawarmahouse.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusUpdateRequest {
    private String orderId;
    private OrderStatus status;

    // Getters and setters
}
