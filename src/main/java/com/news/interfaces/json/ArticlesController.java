package com.news.interfaces.json;

import com.news.application.facade.ArticlesFacade;
import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.ArticlesDtoRq;
import com.news.application.facade.dto.ArticlesDtoRs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Sukh on 2017-01-21.
 */
@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Inject
    private ArticlesFacade articlesFacade;

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public ResponseEntity<ArticlesDtoRs> getArticles(
            @RequestParam(value="sort", required=false, defaultValue = AppConstant.DESCENDING)
            String sort,@RequestBody List<ArticlesDtoRq> req) {
        return new ResponseEntity<>(articlesFacade.getArticles(sort, req), HttpStatus.OK);
    }

}
