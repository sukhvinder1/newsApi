package com.news.application.facade;

import com.news.application.facade.dto.CategoriesDto;
import com.news.application.facade.dto.Category;
import com.news.application.facade.dto.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sukh on 2017-01-13.
 */
@PropertySource("classpath:application.properties")
public class CategoriesMapper {

    @Autowired
    private Environment env;

    public CategoriesDto prepareDto(){
        CategoriesDto dto = new CategoriesDto();
        dto.setCategory(prepareCategoryList());
        return dto;
    }

    private List<Category> prepareCategoryList(){
        List<Category> categoryList = new ArrayList<>();
        Category category = new Category();
        category.setSources(prepareListOfSources());
        return categoryList;
    }

    private List<Source> prepareListOfSources(){
        List<Source> sources = new ArrayList<>();
        Source source = new Source();
        source.setId("test");
        source.setName(env.getProperty("sourceName.mashable"));
        sources.add(source);
        return sources;
    }
}
