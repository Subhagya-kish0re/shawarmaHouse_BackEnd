package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.repository.OrdersRepository;
import com.example.shawarmahouse.util.OrderNotFoundException;
import com.example.shawarmahouse.util.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    private final OrdersRepository ordersRepository;

    public OrderServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrders(){
        return (List<Orders>) ordersRepository.findAll();
    }


    @Override
    public Orders createOrder(String userId, String username,String phonenumber,
                              HashMap<String, Integer> itemsWithQuantity, int totalAmount) {
        log.info("placing order with userid"+userId);
        LocalDateTime orderDate = LocalDateTime.now();
        Orders order = Orders.builder()
                .userId(userId)
                .orderDate(currentDateTime())
                .userName(username)
                .phoneNumber(phonenumber)
                .status((OrderStatus.ORDERED))
                .itemsWithQuantity(itemsWithQuantity)
                .totalAmount(totalAmount)
                .build();
        log.info("order placed");
        return ordersRepository.save(order);
    }

    @Override
    public Optional<Orders> getOrderById(String orderId) {
        return ordersRepository.findById(orderId);
    }

    @Override
    public List<Orders> orderList() {
        log.info("getting all orders");
        return (List<Orders>) ordersRepository.findAll();
    }

    @Override
    public List<Orders> getOrdersWithStatusOrdered() {
        return ordersRepository.findByStatus(OrderStatus.ORDERED);
    }

        @Override
    public Orders updateOrderStatus(String orderId, OrderStatus newStatus) {
        log.info("Updating order status of "+orderId + " to "+newStatus);
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + orderId));
        order.setStatus(newStatus);
        return ordersRepository.save(order);
    }

    @Override
    public void removeOrder(String orderId) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + orderId));
        ordersRepository.delete(order);
    }

    @Override
    public List<Orders> findOrdersByStatuses(List<OrderStatus> statuses) {
        List<Orders> orders = new ArrayList<>();
        for (OrderStatus status : statuses) {
            orders.addAll(ordersRepository.findByStatus(status));
        }
        return orders;
    }
    private String currentDateTime(){
        // Current time in local timezone
        LocalDateTime orderDate = LocalDateTime.now();

        // Convert to IST timezone
        ZonedDateTime istDateTime = orderDate.atZone(ZoneId.systemDefault())
                .withZoneSameInstant(ZoneId.of("Asia/Kolkata"));

        // Format as string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = istDateTime.format(formatter);

        return formattedDate;
    }

}
