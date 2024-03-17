package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.Orders;

import java.util.HashMap;
import java.util.Optional;

public interface OrderService {

    Orders createOrder(String userId, String username,
                       HashMap<String, Integer> itemsWithQuantity, int totalAmount);

    Optional<Orders> getOrderById(String orderId);
}
