package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.repository.AllOrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class AllOrdersServiceImpl implements AllOrdersService{

    private final AllOrdersRepository allOrdersRepository;

    public AllOrdersServiceImpl(AllOrdersRepository allOrdersRepository) {
        this.allOrdersRepository = allOrdersRepository;
    }

    @Override
    public AllOrders savingOrderDetails(Orders order) {
        log.info("saving order with userid");
        LocalDate orderDate = LocalDate.now();
        AllOrders allOrders= AllOrders.builder()
                .id(order.getId()).
                orderDate(orderDate).
                userName(order.getUserName()).
                userId(order.getUserId()).
                phoneNumber(order.getPhoneNumber())
                .itemsWithQuantity(order.getItemsWithQuantity())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .build();



        log.info("order saved");
        AllOrders allOrders1= allOrdersRepository.save(order);
        return allOrders1;
    }
}
