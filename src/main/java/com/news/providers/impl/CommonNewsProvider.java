package com.news.providers.impl;

import com.news.application.facade.dto.Categories;
import com.news.application.facade.dto.Sources;
import com.news.providers.NewsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-30.
 */
public class CommonNewsProvider implements NewsProvider {

    @Override
    public Categories getArticles(List<String> sourcesList) {

        Categories categories = new Categories();
        ConcurrentHashMap<String, List<Sources>> sourcesMap = new ConcurrentHashMap<>();
        for(String source : sourcesList) {
//            here we will get articles from cache or bigHashmap, key will be the source name
//            sourcesMap.put(source, backend.getSourceArticle(source));
            sourcesMap.put(source, mockSourceList());

        }
        categories.setSources(sourcesMap);
        return categories;
    }

    private List<Sources> mockSourceList() {
        List<Sources> sourcesList = new ArrayList<>();
        Sources sources = new Sources();
        sources.setTitle("NEWS TITTLE");
        sources.setUrl("URL");
        sources.setImageUrl("IMAGE URL");
        sources.setDate(null);
        sourcesList.add(sources);
        return sourcesList;
    }
}
