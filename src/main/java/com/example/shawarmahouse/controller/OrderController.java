package com.example.shawarmahouse.controller;


import com.example.shawarmahouse.dto.OrderRequest;
import com.example.shawarmahouse.dto.OrderStatusUpdateRequest;
import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.service.AllOrdersService;
import com.example.shawarmahouse.service.OrderService;
import com.example.shawarmahouse.util.OrderStatus;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
public class OrderController {

    private final OrderService orderService;

    private final AllOrdersService allOrdersService;

    public OrderController(OrderService orderService, AllOrdersService allOrdersService) {
        this.orderService = orderService;
        this.allOrdersService = allOrdersService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Orders> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
//        String userId = (String) orderRequest.get("userId");
//        String status = (String) orderRequest.get("status");
//        HashMap<String, Integer> itemsWithQuantity = (HashMap<String, Integer>) orderRequest.get("itemsWithQuantity");
//        int totalAmount = (int) orderRequest.get("totalAmount");

        Orders order = orderService.createOrder(orderRequest.getUserId(),orderRequest.getUserName(),orderRequest.getPhoneNumber(),orderRequest.getItemsWithQuantity(),orderRequest.getTotalAmount());
//        (userId, status, itemsWithQuantity, totalAmount);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrders")
    public List<Orders> getAllOrders() {
        return orderService.orderList();
    }

    @GetMapping("/ordered")
    public List<Orders> getOrdersWithStatusOrdered() {
        return orderService.getOrdersWithStatusOrdered();
    }

    @PostMapping("/updateOrderStatus")
    public ResponseEntity<Orders> updateOrderStatus(@RequestBody OrderStatusUpdateRequest request) {
        Orders updatedOrder = orderService.updateOrderStatus(request.getOrderId(), request.getStatus());
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/removeOrder/{orderId}")
    public ResponseEntity<String> removeOrder(@PathVariable String orderId) {
        Optional<Orders> orders=orderService.getOrderById(orderId);

        allOrdersService.savingOrderDetails(orders.get());
        log.info("Order saved into All orders Table");
        orderService.removeOrder(orderId);
        log.info("Order details deleted");
        return ResponseEntity.ok("Order successfully deleted");
    }
    @PostMapping("/createallOrder")
    public ResponseEntity<AllOrders> createAllOrder(@Valid @RequestBody OrderRequest orderRequest) {

        LocalDateTime orderDate = LocalDateTime.now();
        Orders order = Orders.builder()
                .userId(orderRequest.getUserId())
                .orderDate(orderDate)
                .userName(orderRequest.getUserName())
                .phoneNumber(orderRequest.getPhoneNumber())
                .status((OrderStatus.PAID))
                .itemsWithQuantity(orderRequest.getItemsWithQuantity())
                .totalAmount(orderRequest.getTotalAmount())
                .build();
        AllOrders neworder = allOrdersService.savingOrderDetails(order);
//        (userId, status, itemsWithQuantity, totalAmount);
        return new ResponseEntity<>(neworder, HttpStatus.CREATED);
    }
    @GetMapping("/status")
    public ResponseEntity<List<Orders>> getOrdersByStatuses() {
        List<OrderStatus> orderStatusList= Arrays.asList(OrderStatus.ORDERED,OrderStatus.READY,OrderStatus.DELIVERED,OrderStatus.PAID);
        List<Orders> orders = orderService.findOrdersByStatuses(orderStatusList);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
