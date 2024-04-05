package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AllOrdersService {

    AllOrders savingOrderDetails(Orders order);

    int getOrderCountByPhoneNumber(String phoneNumber);

    List<AllOrders> getOrdersByPhoneNumber(String phoneNumber);
}
