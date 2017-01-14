package com.news.interfaces.json;

import com.news.application.facade.CategoryFacade;
import com.news.application.facade.dto.CategoriesDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Sukhvinder on 1/13/2017.
 */

@RestController
@RequestMapping("/category")
public class CategotyController {

    @Inject
    private CategoryFacade categoryFacade;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public CategoriesDto getCategories(){
        return categoryFacade.getCategories();
    }
}
