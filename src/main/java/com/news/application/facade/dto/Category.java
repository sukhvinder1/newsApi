package com.news.application.facade.dto;

import java.util.List;

/**
 * Created by sukh on 2017-01-13.
 */
public class Category {
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
