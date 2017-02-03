package com.news.providers.impl;

import com.news.application.facade.dto.Categories;
import com.news.application.facade.dto.Sources;
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
            sourcesMap.put(source, dataHub.getNewsForSource(source));
        }
        categories.setSources(sourcesMap);
        return categories;
    }
}
