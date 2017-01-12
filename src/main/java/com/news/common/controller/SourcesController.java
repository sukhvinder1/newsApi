/**
 * created by Sukhvinder Singh on - 5th January 2017
 * Copyright © 2017 Sukhvinder Singh. All rights reserved.
 */
package com.news.common.controller;

import java.awt.PageAttributes.MediaType;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.news.common.dto.Source;
import com.news.common.dto.SourcesDto;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Sukh
 */
@RestController
@RequestMapping("/sources")
@PropertySource("classpath:application.properties")
public class SourcesController {


	@Autowired
	private Environment env;

	@RequestMapping(value = "/sukh", method = RequestMethod.GET)
	@ResponseBody
	public SourcesDto getSources() {
		SourcesDto dto = new SourcesDto();
		dto.setSources(getSourceList());
		return dto;
	}

	private SyndFeed getFeed() {
		SyndFeed feed = null;
		try {
			URL feedUrl = new URL(env.getProperty("hindtimes.url"));
			//URL feedUrl = new URL("http://rss.cbc.ca/lineup/topstories.xml");
			SyndFeedInput input = new SyndFeedInput();
			feed = input.build(new XmlReader(feedUrl));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}

		return feed;
	}

	private List<Source> getSourceList() {
		List<Source> listOfSource = new ArrayList<>();
		
		if (getFeed() != null){
			List<SyndEntry> items = getFeed().getEntries();
			if (items != null) {
				for (SyndEntry item : items) {
					Source source = new Source();
					source.setLink(item.getLink().toString());
					source.setAuthor(item.getAuthor().toString());
					source.setTitle(item.getTitle().toString());
					listOfSource.add(source);
				}
			}
		}
		return listOfSource;
	}

}
