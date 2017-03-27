package com.news.interfaces.json;

import com.news.application.facade.dto.CategoriesDto;
import com.news.architecture.Exceptions.NewsSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sukhsingh on 2017-03-27.
 */
@RestController
@RequestMapping("/authTest")
public class AuthController {

    @RequestMapping(value = "/testPing", method = RequestMethod.GET)
    public ResponseEntity<String> getError(){
        System.out.println("inside testping");
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}
