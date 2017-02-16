package com.news.providers.Backend.impl;

import com.news.application.facade.constant.AppConstant;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Sukh on 2017-02-03.
 */
public class ScheduledService {

    @Inject
    private DataHub dataHub;

    Logger logger = Logger.getLogger(ScheduledService.class);

//    @Scheduled(fixedDelay = AppConstant.TIME_TEN_MINS)
    public void demoServiceMethod()
    {
        logger.info("Before getting latest news");
        dataHub.getLatestNews();
        logger.info(" After getting latest news");
    }
}
