package com.news.providers.Backend.impl;

import com.news.application.facade.constant.AppConstant;
import org.springframework.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Sukh on 2017-02-03.
 */
public class ScheduledService {

    @Inject
    private DataHub dataHub;

    @Scheduled(fixedDelay = AppConstant.TIME)
    public void demoServiceMethod()
    {
        System.out.println("Before method - Current time is :: "+ new Date());
        dataHub.getLatestNews();
        System.out.println(" After method - Current time is :: "+ new Date());
    }
}
