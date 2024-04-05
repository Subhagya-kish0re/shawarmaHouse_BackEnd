package com.example.shawarmahouse.controller;

import com.example.shawarmahouse.dto.OrderRequest;
import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.service.AllOrdersService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
@Slf4j
@RequestMapping("/shawarmahouse/v1")
public class AllOrdersController {

    private final AllOrdersService allOrdersService;

    public AllOrdersController(AllOrdersService allOrdersService) {
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/createAllOrder")
    public ResponseEntity<AllOrders> createOrder(@Valid @RequestBody Orders orders) {

        AllOrders order = allOrdersService.savingOrderDetails(orders);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @GetMapping("/count/{phoneNumber}")
    public ResponseEntity<Integer> getOrderCountByPhoneNumber(@PathVariable String phoneNumber) {
        int orderCount = allOrdersService.getOrderCountByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(orderCount, HttpStatus.OK);
    }

    @GetMapping("/byPhoneNumber/{phoneNumber}")
    public ResponseEntity<List<AllOrders>> getOrdersByPhoneNumber(@PathVariable String phoneNumber) {
        List<AllOrders> orders = allOrdersService.getOrdersByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
