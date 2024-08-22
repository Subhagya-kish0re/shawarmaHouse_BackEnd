package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.repository.AllOrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        AllOrders allorders= buildNewAllOrder(order);



        log.info("order saved");
        AllOrders allOrders1= allOrdersRepository.save(allorders);
        return allOrders1;
    }

    @Override
    public int getOrderCountByPhoneNumber(String phoneNumber) {
        return allOrdersRepository.countByPhoneNumber(phoneNumber);
    }

    @Override
    public List<AllOrders> getOrdersByPhoneNumber(String phoneNumber) {
        return allOrdersRepository.findByPhoneNumber(phoneNumber);
    }

    private AllOrders buildNewAllOrder(Orders order) {

        LocalDate orderDate = LocalDate.now();
        AllOrders allOrders= AllOrders.builder()
                .id(order.getId()).
                orderDate(currentDateTime()).
                userName(order.getUserName()).
                userId(order.getUserId()).
                phoneNumber(order.getPhoneNumber())
                .itemsWithQuantity(order.getItemsWithQuantity())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .build();
        return  allOrders;
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
