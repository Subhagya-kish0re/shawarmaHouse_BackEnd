package com.example.shawarmahouse.model;


import com.example.shawarmahouse.util.OrderStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@Document(collection = "allorders")
@Builder
@Data
public class AllOrders {

    @Id
    private String id;

    private String userId;

    private String userName;

    private String phoneNumber;

    private String orderDate;


    private OrderStatus status;

    private HashMap<String, Integer> itemsWithQuantity;

    private long totalAmount;


}

