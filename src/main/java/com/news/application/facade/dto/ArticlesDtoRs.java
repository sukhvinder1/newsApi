package com.news.application.facade.dto;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-21.
 */
public class ArticlesDtoRs {
    ConcurrentHashMap<String, Categories> categories;

    public ConcurrentHashMap<String, Categories> getCategories() {
        return categories;
    }

    public void setCategories(ConcurrentHashMap<String, Categories> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ArticlesDtoRs{" +
                "categories=" + categories +
                '}';
    }
}



