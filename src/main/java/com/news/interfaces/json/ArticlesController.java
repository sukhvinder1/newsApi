package com.news.interfaces.json;

import com.news.application.facade.ArticlesFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by sinsukhv on 2017-01-21.
 */
@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Inject
    private ArticlesFacade articlesFacade;


}
