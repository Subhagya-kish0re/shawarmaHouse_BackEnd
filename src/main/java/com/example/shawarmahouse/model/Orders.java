package com.example.shawarmahouse.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Document(collection = "orders")
@Builder
@Data
public class Orders {

    @Id
    private String id;

    private String userId;

    private String userName;

    private String Username;

    private LocalDateTime orderDate;

    private String status;

    private HashMap<String, Integer> itemsWithQuantity;

    private int totalAmount;


}

