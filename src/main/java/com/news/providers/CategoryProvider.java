package com.news.providers;

import com.news.application.facade.dto.CategoriesDto;

import java.util.List;

/**
 * Created by SinSukhv on 1/13/2017.
 */
public interface CategoryProvider {

    List<CategoriesDto> getCategories();
}
