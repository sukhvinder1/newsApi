package com.news.application.facade;

import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;

import java.util.List;

/**
 * Created by Sukh on 2017-01-21.
 */
public interface ArticlesFacade {

      List<ArticlesDtoRs> getArticles(List<ArticlesDtoRq> req);


}