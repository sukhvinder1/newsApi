package com.news.application.facade.impl;

import com.news.application.facade.ArticlesFacade;
import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.providers.impl.*;
import com.news.application.facade.util.SortArticles;
import com.news.providers.impl.TechnologyProviderImpl;
import com.news.providers.impl.TopNewsProviderImpl;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Sukh on 2017-01-21.
 */
public class ArticlesFacadeImpl implements ArticlesFacade {

    @Inject
    private TechnologyProviderImpl technologyProvider;

    @Inject
    private SortArticles sortArticles;

    @Inject
    private TopNewsProviderImpl topNewsProvider;

    @Inject
    private SportsNewsProviderImpl sportsNewsProvider;

    @Inject
    private BusinessNewsProviderImpl businessNewsProvider;

    @Inject
    private LocalNewsProviderImpl localNewsProvider;

    @Inject
    private FinanceNewsProviderImpl financeNewsProvider;

    @Inject
    private EntertainmentNewsProviderImpl entertainmentNewsProvider;

    private List<ArticlesDtoRs> articlesDtoRs;

    @Override
    public List<ArticlesDtoRs> getArticles(String sort, List<ArticlesDtoRq> req) {
        articlesDtoRs = new ArrayList<>();
        for(ArticlesDtoRq articlesDtoRq : req) {
            delegatingToProvider(articlesDtoRq.getCategoryName(), articlesDtoRq.getSources(), sort);
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
    private List<ArticlesDtoRs> delegatingToProvider(String category, List<String> sourcesList, String sort){
        switch (category) {
            case "tech":
                articlesDtoRs.addAll(technologyProvider.getArticles(sourcesList));
                break;
            case "top":
                articlesDtoRs.addAll(topNewsProvider.getArticles(sourcesList));
                break;
            case "business":
                articlesDtoRs.addAll(businessNewsProvider.getArticles(sourcesList));
                break;
            case "sports":
                articlesDtoRs.addAll(sportsNewsProvider.getArticles(sourcesList));
                break;
            case "finance":
                articlesDtoRs.addAll(financeNewsProvider.getArticles(sourcesList));
                break;
            case "entertainment":
                articlesDtoRs.addAll(entertainmentNewsProvider.getArticles(sourcesList));
                break;
            case "local":
                articlesDtoRs.addAll(localNewsProvider.getArticles(sourcesList));
                break;
            //TODO add default case
        }

        if(sort.equalsIgnoreCase(AppConstant.DESCENDING))
            sortArticles.sortArticles(articlesDtoRs, sort);
        sortArticles.sortArticles(articlesDtoRs, sort);

        return articlesDtoRs;
    }


}