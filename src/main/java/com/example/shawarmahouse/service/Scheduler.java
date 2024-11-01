package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class Scheduler {
    private final OrdersRepository ordersRepository;

    public Scheduler(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Scheduled(cron = "0 */14 * * * ?") // Every minute
    public void logMessage() {
            List< Orders>orders = (List<Orders>) ordersRepository.findAll();
            if(orders.size()!=0){
                log.info("Succesfull");
            }
        System.out.println("Log Message: This is a scheduled log message | Time: " + LocalDateTime.now());
    }
}
