package com.news.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorld {

	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String get() {
		return "Hello World!!";
	}
	
}
