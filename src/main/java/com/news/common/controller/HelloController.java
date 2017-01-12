/**
 * created by Sukhvinder Singh on - 5th January 2017
 * Copyright © 2017 Sukhvinder Singh. All rights reserved.
 */
package com.news.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



public class HelloController {
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String get() {
		return "Hello World!!";
	}
	
}
