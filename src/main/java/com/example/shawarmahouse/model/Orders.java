package com.example.shawarmahouse.model;

import com.example.shawarmahouse.util.OrderStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;

@Document(collection = "orders")
@Builder
@Data
public class Orders {

    @Id
    private String id;

    private String userId;

    private String userName;

    private String phoneNumber;

    private LocalDateTime orderDate;


    private String status;

    private HashMap<String, Integer> itemsWithQuantity;

    private int totalAmount;


}

