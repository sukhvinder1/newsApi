package com.news.application.facade.dto;

import java.util.List;

/**
 * Created by sukh on 2017-01-13.
 */
public class CategoriesDto {
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
