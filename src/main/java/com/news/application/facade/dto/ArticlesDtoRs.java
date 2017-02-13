package com.news.application.facade.dto;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-21.
 */
public class ArticlesDtoRs {

    private ConcurrentHashMap<String, List<Sources>> sources;

    public ConcurrentHashMap<String, List<Sources>> getSources() {
        return sources;
    }

    public void setSources(ConcurrentHashMap<String, List<Sources>> sources) {
        this.sources = sources;
    }
}



