package com.news.application.facade.mapper;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.CategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by sukh on 2017-01-13.
 */
@Component
public class CategoriesMapper {

    @Autowired
    private Properties properties;

    private List<String> techSources = new ArrayList<>();
    private List<String> topSources = new ArrayList<>();

    public List<CategoriesDto> prepareDto(){
        //creating enumeration for all the properties name
        Enumeration e = properties.propertyNames();

        while (e.hasMoreElements()) {
            //getting the key
            String key = (String) e.nextElement();

            //assign the source to appropriate category
            if (key.contains(AppConstant.TECH)){
                prepareSources(techSources, properties.getProperty(key));
            }else if (key.contains(AppConstant.TOP)){
                prepareSources(topSources, properties.getProperty(key));
            }
        }
        return response();
    }

    private void prepareSources(List<String> sources, String source){
        sources.add(source);
    }

    private  List<CategoriesDto> response(){
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
