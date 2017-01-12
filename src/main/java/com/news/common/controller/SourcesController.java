/**
 * created by Sukhvinder Singh on - 5th January 2017
 * Copyright © 2017 Sukhvinder Singh. All rights reserved.
 */
package com.news.common.controller;

import java.awt.PageAttributes.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.news.common.dto.Sukh;

/**
 * @author Sukh
 */
@RestController
@RequestMapping("/sources")
public class SourcesController {
	
	@RequestMapping(value="/sukh", method = RequestMethod.GET)
	@ResponseBody
	public Sukh getSources(){
		Sukh sukh = new Sukh();
		sukh.setAge("24");
		sukh.setName("SukhvinderSingh");
		return sukh;
	}

}
