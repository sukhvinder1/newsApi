package com.news.application.facade.impl;

import com.news.application.facade.CategoryFacade;
import com.news.application.facade.dto.CategoriesDto;
import com.news.application.facade.mapper.CategoriesMapper;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sukh on 1/13/2017.
 */
public class CategoryFacadeImpl implements CategoryFacade {

    @Inject
    CategoriesMapper categoryMapper;

    @Override
    public  List<CategoriesDto> getCategories() {
        return categoryMapper.prepareDto();
    }
}
