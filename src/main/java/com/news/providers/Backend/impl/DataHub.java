package com.news.providers.Backend.impl;

import com.news.application.facade.dto.Sources;
import com.news.architecture.Exceptions.NewsSystemException;
import com.news.architecture.util.ValidationUtil;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-02-03.
 */
public class DataHub {

    @Inject
    private RomeServiceProviderImpl provider;

    Logger logger = Logger.getLogger(DataHub.class);

    private boolean isUpdating = false;
    ConcurrentHashMap<String, List<Sources>> mainHashMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<Sources>> tempHashMap = new ConcurrentHashMap<>();

    public void getLatestNews() {
        tempHashMap = provider.getAllArticles();
        if (ValidationUtil.isMapNullOrEmpty(tempHashMap)) {
            throw new NewsSystemException("HashMap from from rome provider");
        }
        isUpdating = true;
        updateMainHashMap();
    }

    public List<Sources> getNewsForSource(String sourceId) {
        // TODO use intances
        if (isUpdating) {
            try {
                wait(1000);
                getNewsForSource(sourceId);
            } catch (InterruptedException e){
                logger.error(e);
                throw new NewsSystemException("Thread InterruptedException");
            }
        }

        List<Sources> sources = mainHashMap.get(sourceId);
        if (ValidationUtil.isCollectionNullOrEmpty(sources)) {
            throw new NewsSystemException("Sources are null at DataHub");
        }

        return sources;
    }

    private void updateMainHashMap() {
        mainHashMap.clear();
        setMainHashMap(tempHashMap);
        isUpdating = false;
    }

    private void setMainHashMap(ConcurrentHashMap<String, List<Sources>> mainHashMap) {
        this.mainHashMap = mainHashMap;
    }
}
