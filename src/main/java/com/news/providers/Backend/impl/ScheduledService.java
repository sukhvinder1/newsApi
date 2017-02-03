package com.news.providers.Backend.impl;

import org.springframework.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Sukh on 2017-02-03.
 */
public class ScheduledService {

    @Inject
    private DataHub dataHub;

    // one min
    final long TIME = 300000;

    @Scheduled(fixedDelay = TIME)
    public void demoServiceMethod()
    {
        System.out.println("Before method - Current time is :: "+ new Date());
        dataHub.getLatestNews();
        System.out.println(" After method - Current time is :: "+ new Date());
    }
}
