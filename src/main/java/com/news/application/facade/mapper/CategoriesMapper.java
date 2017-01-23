package com.news.application.facade.mapper;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.CategoriesDto;
import com.news.architecture.util.PropertyManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by sukh on 2017-01-13.
 */
public class CategoriesMapper {

    @Inject
    private PropertyManager propertyManager;

    private List<String> techSources, topSources, sportsSources, businessSources, financeSources, entertainmentSources, localSources;
    List<CategoriesDto> categoriesDtoList;

    public List<CategoriesDto> prepareDto() {
        initializingVariables();

        //creating enumeration for all the properties name
        Enumeration e = propertyManager.getPropertyNames();

        while (e.hasMoreElements()) {
            //getting the key
            String key = (String) e.nextElement();

            //assign the source to appropriate category
            if (key.contains(AppConstant.TECH)) {
                prepareSources(techSources, propertyManager.getProperty(key));
            } else if (key.contains(AppConstant.TOP)) {
                prepareSources(topSources, propertyManager.getProperty(key));
            } else if (key.contains(AppConstant.SPORTS)) {
                prepareSources(sportsSources, propertyManager.getProperty(key));
            } else if (key.contains(AppConstant.BUSINESS)) {
                prepareSources(businessSources, propertyManager.getProperty(key));
            } else if (key.contains(AppConstant.FINANCE)) {
                prepareSources(financeSources, propertyManager.getProperty(key));
            } else if (key.contains(AppConstant.ENTERTAINMENT)) {
                prepareSources(entertainmentSources, propertyManager.getProperty(key));
            } else if (key.contains(AppConstant.LOCAL)) {
                prepareSources(localSources, propertyManager.getProperty(key));
            }
        }
        return response();
    }

    private void prepareSources(List<String> sources, String source){
        sources.add(source);
    }

    private  List<CategoriesDto> response() {
        prepareList(AppConstant.TECH, techSources);
        prepareList(AppConstant.TOP, topSources);
        prepareList(AppConstant.SPORTS, sportsSources);
        prepareList(AppConstant.BUSINESS, businessSources);
        prepareList(AppConstant.FINANCE, financeSources);
        prepareList(AppConstant.ENTERTAINMENT, entertainmentSources);
        prepareList(AppConstant.LOCAL, localSources);

        return categoriesDtoList;
    }

    private void prepareList(String category, List<String> sources){
        CategoriesDto dto = new CategoriesDto();
        dto.setCategoryName(category);
        dto.setSources(sources);
        categoriesDtoList.add(dto);
    }

    private void initializingVariables(){
        categoriesDtoList = new ArrayList<>();
        techSources = new ArrayList<>();
        topSources = new ArrayList<>();
        sportsSources = new ArrayList<>();
        businessSources = new ArrayList<>();
        financeSources = new ArrayList<>();
        entertainmentSources = new ArrayList<>();
        localSources = new ArrayList<>();
    }
}
