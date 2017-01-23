package com.news.providers;

import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.application.facade.dto.CategoriesDto;

import java.util.List;

/**
 * Created by Sukh on 1/13/2017.
 */
public interface NewsProvider {

    List<ArticlesDtoRs> getArticles(List<String> sourcesList);
}
