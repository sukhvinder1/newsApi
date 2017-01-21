package com.news.application.facade;

import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;

import java.util.List;

/**
 * Created by sinsukhv on 2017-01-21.
 */
public interface ArticlesFacade {

      List<ArticlesDtoRs> getArticles(ArticlesDtoRq req);


}