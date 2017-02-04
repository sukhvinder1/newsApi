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
    public Categories getArticles(List<String> sourcesList) {

        Categories categories = new Categories();
        ConcurrentHashMap<String, List<Sources>> sourcesMap = new ConcurrentHashMap<>();

        for(String source : sourcesList) {
            List<Sources> sources = dataHub.getNewsForSource(source);
            if (ValidationUtil.isCollectionNullOrEmpty(sources)) {
                throw new NewsSystemException("source list is null at provider");
            }
            sourcesMap.put(source, sources);
        }

        if (ValidationUtil.isMapNullOrEmpty(sourcesMap)) {
            throw new NewsSystemException("Null map at provider");
        }

        categories.setSources(sourcesMap);
        return categories;
    }
}
