package com.news.providers.impl;

import com.news.application.facade.dto.ArticlesDtoRs;
import com.news.providers.Entity.RomeDO;

/**
 * Created by Sukh on 2017-01-23.
 */
public class CommonProviderHelper {

    public ArticlesDtoRs prepareCommonRs(ArticlesDtoRs articlesDtoRs, RomeDO romeDO) {
        articlesDtoRs.setDate(romeDO.getDate());
        articlesDtoRs.setImageUrl(romeDO.getImageUrl());
        articlesDtoRs.setUrl(romeDO.getUrl());
        articlesDtoRs.setTitle(romeDO.getTitle());
        return articlesDtoRs;
    }
}
