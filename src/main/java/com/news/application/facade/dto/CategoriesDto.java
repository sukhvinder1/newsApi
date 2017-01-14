package com.news.application.facade.dto;

import java.util.List;

/**
 * Created by sukh on 2017-01-13.
 */
public class CategoriesDto {

    private List<Category> category;

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
