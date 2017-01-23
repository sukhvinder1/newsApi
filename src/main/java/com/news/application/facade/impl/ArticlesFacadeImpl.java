package com.news.application.facade.impl;

import com.news.application.facade.ArticlesFacade;
import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.providers.impl.TechnologyProviderImpl;
import com.news.providers.impl.TopNewsProviderImpl;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukh on 2017-01-21.
 */
public class ArticlesFacadeImpl implements ArticlesFacade {

    @Inject
    private TechnologyProviderImpl technologyProvider;

    @Inject
    private TopNewsProviderImpl topNewsProvider;

    private List<ArticlesDtoRs> articlesDtoRs;

    @Override
    public List<ArticlesDtoRs> getArticles(List<ArticlesDtoRq> req) {
        articlesDtoRs = new ArrayList<>();
        for(ArticlesDtoRq articlesDtoRq : req) {
            delegatingToProvider(articlesDtoRq.getCategoryName(), articlesDtoRq.getSources());
        }
        System.out.println("number of articles : " + articlesDtoRs.size());
        return articlesDtoRs;
    }

    /**
     * @param category
     * @param sourcesList
     * this method will delegate to appropriate provider based on the category param
     * and it will bring the list of Articles and add it to response
     */
    private List<ArticlesDtoRs> delegatingToProvider(String category, List<String> sourcesList){
        switch (category) {
            case "tech":
                articlesDtoRs.addAll(technologyProvider.getArticles(sourcesList));
                break;
            case "top":
                articlesDtoRs.addAll(topNewsProvider.getArticles(sourcesList));
                break;
            //TODO still have to add others cases
        }

        return articlesDtoRs;
    }
}
