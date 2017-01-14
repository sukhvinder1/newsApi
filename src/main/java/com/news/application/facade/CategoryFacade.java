package com.news.application.facade;

import com.news.application.facade.dto.CategoriesDto;

import java.util.List;

/**
 * Created by SinSukhv on 1/13/2017.
 */
public interface CategoryFacade {
    List<CategoriesDto> getCategories();
}
