package com.example.demo.hexagonal_architecture.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.concurrent.ScheduledFuture;

@Service
@RequiredArgsConstructor
public class CounterService {

    private int COUNTER = 31;
    private boolean isActive = true;
    private ScheduledFuture<?> scheduledFuture;

    private final TaskScheduler taskScheduler;

    public void startCounterTask() {
        scheduledFuture = taskScheduler.scheduleAtFixedRate(this::decrementCounter, 1000);
    }

    public void stopCounterTask() {
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(true);
        }
    }

    @Scheduled(fixedRate = 1000)
    public int decrementCounter() {
        if (isActive) {
            if (COUNTER > 0) {
                COUNTER--;
                System.out.println("Counter: " + COUNTER);
            }
            if (COUNTER == 0) {
                isActive = false;
                stopCounterTask();
            }
        }
        return COUNTER;
    }
}