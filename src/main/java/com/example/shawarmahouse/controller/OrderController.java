package com.example.shawarmahouse.controller;


import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shawarmahouse/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @GetMapping("/getAllOrders")
//    public ResponseEntity<List<Orders>> getAllOrders(){
//
//    }
}
