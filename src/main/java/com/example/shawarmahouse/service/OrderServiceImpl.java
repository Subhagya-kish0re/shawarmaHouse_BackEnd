package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.repository.OrdersRepository;
import com.example.shawarmahouse.util.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
                .orderDate(orderDate)
                .userName(username)
                .phoneNumber(phonenumber)
                .status((OrderStatus.ORDERED).toString())
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
        return ordersRepository.findByStatus(OrderStatus.ORDERED.toString());
    }



}
