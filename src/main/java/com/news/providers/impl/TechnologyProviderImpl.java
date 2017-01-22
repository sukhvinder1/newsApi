package com.news.providers.impl;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.application.facade.util.PropertyManager;
import com.news.providers.Backend.RomeServiceProvider;
import com.news.providers.Backend.impl.RomeServiceProviderImpl;
import com.news.providers.CategoryProvider;
import com.news.providers.Entity.RomeDO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukh on 2017-01-21.
 */
public class TechnologyProviderImpl implements CategoryProvider {

    @Inject
    private PropertyManager propertyManager;

    @Inject
    private RomeServiceProviderImpl romeServiceProvider;

    @Override
    public List<ArticlesDtoRs> getArticles(List<String> sourcesList) {
        List<ArticlesDtoRs> response = new ArrayList<>();
        for(String source : sourcesList) {
            List<RomeDO> romeDOList = romeServiceProvider.getRomeDO(propertyManager.getSourcePropertyUrl(source));
            for (RomeDO romeDO : romeDOList) {
                ArticlesDtoRs articlesDtoRs = new ArticlesDtoRs();
                articlesDtoRs.setCategory(AppConstant.TECH);
                articlesDtoRs.setDate(romeDO.getDate());
                articlesDtoRs.setImageUrl(romeDO.getImageUrl());
                articlesDtoRs.setUrl(romeDO.getUrl());
                articlesDtoRs.setTitle(romeDO.getTitle());
                response.add(articlesDtoRs);
            }
        }
        return response;
    }
}
