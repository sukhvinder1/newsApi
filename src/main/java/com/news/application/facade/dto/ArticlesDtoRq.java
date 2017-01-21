package com.news.application.facade.dto;

import java.util.List;

/**
 * Created by sinsukhv on 2017-01-21.
 */
public class ArticlesDtoRq {
    private String categoryName;
    private List<String> sources = null;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }
}
