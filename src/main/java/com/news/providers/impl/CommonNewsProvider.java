package com.news.providers.impl;

import com.news.application.facade.dto.Categories;
import com.news.application.facade.dto.Sources;
import com.news.architecture.Exceptions.NewsSystemException;
import com.news.architecture.util.ValidationUtil;
import com.news.providers.Backend.impl.DataHub;
import com.news.providers.NewsProvider;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-30.
 */
public class CommonNewsProvider implements NewsProvider {

    @Inject
    private DataHub dataHub;

    @Override
    public List<Sources> getArticles(List<String> sourcesRqList) {

        List<Sources> sourcesRsList = new ArrayList<>();

        for(String source : sourcesRqList) {
            sourcesRsList.addAll(dataHub.getNewsForSource(source));
        }

        if (ValidationUtil.isCollectionNullOrEmpty(sourcesRsList)) {
            throw new NewsSystemException("Null map at provider");
        }

        return sourcesRsList;
    }
}
