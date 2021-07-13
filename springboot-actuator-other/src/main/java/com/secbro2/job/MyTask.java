package com.secbro2.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/13
 **/
@Component
public class MyTask {

    @Scheduled(cron = "0/10 * * * * *")
    public void work() {
        System.out.println("I am a cron job.");
    }

    @Scheduled(fixedDelay = 10000)
    public void work1() {
        System.out.println("I am a fixedDelay job.");
    }
}
