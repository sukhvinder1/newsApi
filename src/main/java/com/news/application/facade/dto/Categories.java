package com.news.application.facade.dto;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sinsukhv on 2017-01-30.
 */
public class Categories {

    ConcurrentHashMap<String, List<Sources>> sources;

    public ConcurrentHashMap<String, List<Sources>> getSources() {
        return sources;
    }

    public void setSources(ConcurrentHashMap<String, List<Sources>> sources) {
        this.sources = sources;
    }
}

