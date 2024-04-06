package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.util.OrderStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Orders createOrder(String userId, String username,String phoneNumber,
                       HashMap<String, Integer> itemsWithQuantity, int totalAmount);

    Optional<Orders> getOrderById(String orderId);
    List<Orders>orderList();

    List<Orders> getOrdersWithStatusOrdered();

    Orders updateOrderStatus(String orderId, OrderStatus newStatus);

    void removeOrder(String orderId);

    List<Orders> findOrdersByStatuses(List<OrderStatus> statuses);
}
