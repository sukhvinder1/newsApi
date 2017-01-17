package com.news.application.facade.mapper;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.CategoriesDto;
import com.news.application.facade.util.PropertyManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by sukh on 2017-01-13.
 */
public class CategoriesMapper {

    @Inject
    PropertyManager propertyManager;

    private List<String> techSources = new ArrayList<>();
    private List<String> topSources = new ArrayList<>();

    public List<CategoriesDto> prepareDto() {
        //creating enumeration for all the properties name
        Enumeration e = propertyManager.getPropertyNames();

        while (e.hasMoreElements()) {
            //getting the key
            String key = (String) e.nextElement();

            //assign the source to appropriate category
            if (key.contains(AppConstant.TECH)){
                prepareSources(techSources, propertyManager.getProperty(key));
            }else if (key.contains(AppConstant.TOP)){
                prepareSources(topSources, propertyManager.getProperty(key));
            }
        }
        return response();
    }

    private void prepareSources(List<String> sources, String source){
        sources.add(source);
    }

    private  List<CategoriesDto> response() {
        List<CategoriesDto> categoriesDtoList = new ArrayList<>();
        CategoriesDto dto = new CategoriesDto();
        dto.setCategoryName(AppConstant.TECHNOLOGY);
        dto.setSources(techSources);

        CategoriesDto dto2 = new CategoriesDto();
        dto2.setCategoryName(AppConstant.TOP_NEWS);
        dto2.setSources(topSources);

        categoriesDtoList.add(dto);
        categoriesDtoList.add(dto2);
        return categoriesDtoList;
    }
}
