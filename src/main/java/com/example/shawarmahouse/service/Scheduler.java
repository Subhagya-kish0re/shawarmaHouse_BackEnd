package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@Component
public class Scheduler {
    private final WebClient webClient;

    @Autowired
    public Scheduler(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://shawarmahouse-backend-6ax5.onrender.com/shawarmahouse/v1").build();
    }

    @Scheduled(fixedRate = 600000) // Run every 10 minutes
    public void fetchShawarmaData() {
        webClient.get()
                .uri("/test")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> {
                    // Handle the response
//                    log.info("Response: " + response);
//                    System.out.println("Response: " + response);
                }, error -> {
                    // Handle any errors
                    log.info("Error occurred in scheduler: " + error.getMessage());
                    System.err.println("Error occurred in scheduler: " + error.getMessage());
                });
    }
}
