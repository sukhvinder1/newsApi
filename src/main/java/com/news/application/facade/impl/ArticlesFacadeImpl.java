package com.news.application.facade.impl;

import com.news.application.facade.ArticlesFacade;
import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.application.facade.dto.Categories;
import com.news.application.facade.dto.Sources;
import com.news.providers.impl.CommonNewsProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-21.
 */
public class ArticlesFacadeImpl implements ArticlesFacade {

    @Inject
    private CommonNewsProvider commonNewsProvider;

    @Override
    public ArticlesDtoRs getArticles(String sort, List<ArticlesDtoRq> req) {

        ArticlesDtoRs articlesDtoRs = new ArticlesDtoRs();
        ConcurrentHashMap<String, Categories> categoriesMap = new ConcurrentHashMap<>();

        for(ArticlesDtoRq articlesDtoRq : req) {
            categoriesMap.put(articlesDtoRq.getCategoryName(), delegatingToProvider(articlesDtoRq));
        }

        int length = 0;
        for (String c : categoriesMap.keySet()) {
            for (String s : categoriesMap.get(c).getSources().keySet()) {
                length += categoriesMap.get(c).getSources().get(s).size();
            }
        }

        System.out.println("Number of article : " + length);

        articlesDtoRs.setCategories(categoriesMap);
        return articlesDtoRs;
    }


    private Categories delegatingToProvider(ArticlesDtoRq articlesDtoRq) {

        return commonNewsProvider.getArticles(articlesDtoRq.getSources());

    }
}