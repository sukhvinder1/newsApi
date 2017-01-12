/**
 * created by Sukhvinder Singh on - 5th January 2017
 * Copyright © 2017 Sukhvinder Singh. All rights reserved.
 */
package com.news.common.controller;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author Sukh
 */
@RunWith(MockitoJUnitRunner.class)
public class SourcesControllerTest {
	
	@Test
	public void test(){
		romeTest();
		assertTrue("true", true);
	}
	
	private void romeTest() {

		try {
			URL feedUrl = new URL("http://www.cbc.ca/cmlink/rss-topstories");
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));
			//System.out.println(feed);
			List<SyndEntry> items = feed.getEntries();
			if(items != null){
				for(SyndEntry item : items){
					System.out.println(item.getLink());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
