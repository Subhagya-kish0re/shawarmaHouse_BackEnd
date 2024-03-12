package com.example.shawarmahouse.controller;


import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"},
        methods = {
                RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST,
                RequestMethod.OPTIONS,
                RequestMethod.PUT
        }
)
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
