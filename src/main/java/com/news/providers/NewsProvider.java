package com.news.providers;

import com.news.application.facade.dto.Categories;
import com.news.application.facade.dto.Sources;

import java.util.List;

/**
 * Created by Sukh on 1/13/2017.
 */
public interface NewsProvider {

    List<Sources> getArticles(List<String> sourcesList);
}
