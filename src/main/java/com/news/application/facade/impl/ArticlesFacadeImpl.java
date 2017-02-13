package com.news.application.facade.impl;

import com.news.application.facade.ArticlesFacade;
import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
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
        ConcurrentHashMap<String, List<Sources>> categoriesMap = new ConcurrentHashMap<>();

        for(ArticlesDtoRq articlesDtoRq : req) {
            categoriesMap.put(articlesDtoRq.getCategoryName(), delegatingToProvider(articlesDtoRq));
        }

        articlesDtoRs.setSources(categoriesMap);

        int length = 0;
        for (String string : categoriesMap.keySet()) {
            length += categoriesMap.get(string).size();
        }

        System.out.println("Number of article : " + length);

        return articlesDtoRs;
    }


    private List<Sources> delegatingToProvider(ArticlesDtoRq articlesDtoRq) {

        return commonNewsProvider.getArticles(articlesDtoRq.getSources());

    }
}