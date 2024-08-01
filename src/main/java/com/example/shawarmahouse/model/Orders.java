package com.example.shawarmahouse.model;

import com.example.shawarmahouse.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

@Document(collection = "orders")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    private String id;

    private String userId;

    private String userName;

    private String phoneNumber;

    private LocalDateTime orderDate;


    private OrderStatus status;

    private HashMap<String, Integer> itemsWithQuantity;

    private long totalAmount;


}

