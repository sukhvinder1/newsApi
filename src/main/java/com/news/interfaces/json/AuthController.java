package com.news.interfaces.json;

import com.news.application.facade.dto.CategoriesDto;
import com.news.architecture.Exceptions.NewsSystemException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sukhsingh on 2017-03-27.
 */
@RestController
@RequestMapping("/authTest")
public class AuthController {

    Logger logger = Logger.getLogger(AuthController.class);

    @RequestMapping(value = "/testPing", method = RequestMethod.GET)
    public ResponseEntity<String> testPing(@RequestParam String response_type,
                                           @RequestParam String client_id,
                                           @RequestParam String state) {

        logger.info("Response type : " + response_type);
        logger.info("client_id  : " + client_id);
        logger.info("state : " + state);
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ResponseEntity<String> token() {
        logger.info("::::::::Inside token ::::::::");
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}
