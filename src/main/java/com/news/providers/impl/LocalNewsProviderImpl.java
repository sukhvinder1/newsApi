package com.news.providers.impl;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.architecture.util.PropertyManager;
import com.news.providers.Backend.RomeServiceProvider;
import com.news.providers.Entity.RomeDO;
import com.news.providers.NewsProvider;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukh on 2017-01-23.
 */
public class LocalNewsProviderImpl implements NewsProvider {
    @Inject
    private RomeServiceProvider romeServiceProvider;

    @Inject
    private PropertyManager propertyManager;

    @Override
    public List<ArticlesDtoRs> getArticles(List<String> sourcesList) {
        List<ArticlesDtoRs> response = new ArrayList<>();
        CommonProviderHelper helper = new CommonProviderHelper();
        for(String source : sourcesList) {
            List<RomeDO> romeDOList = romeServiceProvider.getRomeDO(propertyManager.getSourcePropertyUrl(source));
            for (RomeDO romeDO : romeDOList) {
                ArticlesDtoRs articlesDtoRs = new ArticlesDtoRs();
                articlesDtoRs.setCategory(AppConstant.SPORTS);
                articlesDtoRs = helper.prepareCommonRs(articlesDtoRs, romeDO);
                response.add(articlesDtoRs);
            }
        }
        return response;
    }
}
