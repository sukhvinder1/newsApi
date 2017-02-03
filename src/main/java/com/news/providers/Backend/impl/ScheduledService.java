package com.news.providers.Backend.impl;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by Sukh on 2017-02-03.
 */
public class ScheduledService {

    @Scheduled(fixedDelay = 60000)
    public void demoServiceMethod()
    {
        System.out.println("Method executed at every 1 min. Current time is :: "+ new Date());
    }
}
