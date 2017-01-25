package com.news.application.facade.util;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.ArticlesDtoRs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kshitij108 on 2017-01-22.
 */
public class SortArticles {
    public List<ArticlesDtoRs> sortArticles(List<ArticlesDtoRs> sortArticles, String sort) {

        if(sort.equalsIgnoreCase(AppConstant.DESCENDING)){
        Collections.sort(sortArticles, new Comparator<ArticlesDtoRs>() {
            @Override
            public int compare(ArticlesDtoRs o1, ArticlesDtoRs o2) {
                if (o1.getDate() == null || o2.getDate() == null)
                    return 0;
                return o2.getDate().compareTo(o1.getDate());
            }
        });
    }else if(sort.equalsIgnoreCase(AppConstant.ASCENDING)){
            Collections.sort(sortArticles, new Comparator<ArticlesDtoRs>() {
                @Override
                public int compare(ArticlesDtoRs o1, ArticlesDtoRs o2) {
                    if (o1.getDate() == null || o2.getDate() == null)
                        return 0;
                    return o1.getDate().compareTo(o2.getDate());
                }
            });
        }
        return sortArticles;
    }
}
