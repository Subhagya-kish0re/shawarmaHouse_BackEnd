package com.example.shawarmahouse.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Scheduler {

    @Scheduled(cron = "0 */14 * * * ?") // Every minute
    public void logMessage() {
        System.out.println("Log Message: This is a scheduled log message | Time: " + LocalDateTime.now());
    }
}
