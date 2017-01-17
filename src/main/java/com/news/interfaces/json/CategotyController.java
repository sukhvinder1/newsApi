package com.news.interfaces.json;

import com.news.application.facade.CategoryFacade;
import com.news.application.facade.dto.CategoriesDto;
import com.news.architecture.Exceptions.NewsSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sukhvinder on 1/13/2017.
 */

@RestController
@RequestMapping("/category")
public class CategotyController {

    @Inject
    private CategoryFacade categoryFacade;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<CategoriesDto>> getCategories(){
        return new ResponseEntity<>(categoryFacade.getCategories(), HttpStatus.OK);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseEntity<List<CategoriesDto>> getError(){
        throw new NewsSystemException("Generic Error");
    }
}
