package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import org.springframework.stereotype.Service;


public interface AllOrdersService {

    AllOrders savingOrderDetails(Orders order);
}
