package com.news.application.facade.mapper;

import com.news.application.facade.dto.CategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sukh on 2017-01-13.
 */
@Component
@PropertySource("classpath:application.properties")
public class CategoriesMapper {

    @Autowired
    private Environment env;

    public List<CategoriesDto> prepareDto(){
        //Just to test if its reading properties ot not this will print  "test" in console
        System.out.println(env.getProperty("hindtimes.url"));
        //right now preparing a mock response only
        // once we will decide json format
        // CategoriesDto needs to be refactored
        return mockResponse();
    }


    private  List<CategoriesDto> mockResponse(){
        List<CategoriesDto> categoriesDtoList = new ArrayList<>();
        CategoriesDto dto = new CategoriesDto();
        dto.setCategoryName("Technology");
        List<String> sources = new ArrayList<>();
        sources.add("cbc-tech");
        sources.add("mashable");
        sources.add("android-central");
        dto.setSources(sources);

        CategoriesDto dto2 = new CategoriesDto();
        dto2.setCategoryName("Top News");
        List<String> sources2 = new ArrayList<>();
        sources2.add("cnn");
        sources2.add("bbc");
        sources2.add("timesOfIndia");
        dto2.setSources(sources2);

        categoriesDtoList.add(dto);
        categoriesDtoList.add(dto2);
        return categoriesDtoList;
    }
}
