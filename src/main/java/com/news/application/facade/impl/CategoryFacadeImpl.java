package com.news.application.facade.impl;

import com.news.application.facade.CategoriesMapper;
import com.news.application.facade.CategoryFacade;
import com.news.application.facade.dto.CategoriesDto;
import com.news.application.facade.dto.Category;
import com.news.providers.CategoryProvider;

import javax.inject.Inject;
/**
 * Created by Sukh on 1/13/2017.
 */

public class CategoryFacadeImpl implements CategoryFacade {

    @Inject
    CategoryProvider categoryProvider;

    @Override
    public CategoriesDto getCategories() {
        CategoriesMapper categoriesMapper = new CategoriesMapper();
        return categoriesMapper.prepareDto();
    }
}
