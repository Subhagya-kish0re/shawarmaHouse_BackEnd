package com.example.shawarmahouse.controller;


import com.example.shawarmahouse.dto.OrderRequest;
import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/createOrder")
    public ResponseEntity<Orders> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
//        String userId = (String) orderRequest.get("userId");
//        String status = (String) orderRequest.get("status");
//        HashMap<String, Integer> itemsWithQuantity = (HashMap<String, Integer>) orderRequest.get("itemsWithQuantity");
//        int totalAmount = (int) orderRequest.get("totalAmount");

        Orders order = orderService.createOrder(orderRequest.getUserId(),orderRequest.getUserName(),orderRequest.getItemsWithQuantity(),orderRequest.getTotalAmount());
//        (userId, status, itemsWithQuantity, totalAmount);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
