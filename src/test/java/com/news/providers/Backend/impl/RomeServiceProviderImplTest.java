package com.news.providers.Backend.impl;

import com.news.application.facade.dto.Sources;
import com.news.architecture.util.PropertyManager;
import com.sun.syndication.io.SyndFeedInput;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by Sukh on 2017-02-27.
 */
@RunWith(MockitoJUnitRunner.class)
public class RomeServiceProviderImplTest {

    @InjectMocks
    private RomeServiceProviderImpl impl;

    @Mock
    private PropertyManager propertyManager;

    @Mock
    private SyndFeedInput syndFeedInput;

    @Mock
    private Logger logger;

    @Before
    public void setup() {
        when(propertyManager.getUrlHashMap()).thenReturn(prepareSourcesPropeties());
    }

    @Test
    public void HappyPath() {
        ConcurrentHashMap<String, List<Sources>> response = impl.getAllArticles();
        assertNotNull(response);
        assertEquals(7, response.size());
    }

    @Test
    public void getImageFromContent() {
        ConcurrentHashMap<String, List<Sources>> response = impl.getAllArticles();
        assertNotNull(response);
        assertNotNull(response.get("theVerge").get(0).getImageUrl());
        assertNotNull(response.get("technewsworld").get(0).getImageUrl());
        assertNotNull(response.get("wiredTech").get(0).getImageUrl());
    }

    private HashMap<String, String> prepareSourcesPropeties() {
        HashMap<String, String> map = new HashMap<>();

        //tech
        map.put("bbc-tech", "http://feeds.bbci.co.uk/news/technology/rss.xml");
        map.put("mashable", "http://feeds.mashable.com/Mashable");
        map.put("cnet", "https://www.cnet.com/rss/news/");
        map.put("theVerge", "http://www.theverge.com/rss/index.xml");
        map.put("technewsworld", "http://www.technewsworld.com/perl/syndication/rssfull.pl");
        map.put("wiredTech", "https://www.wired.com/category/gear/feed/");

        // top
        map.put("timesOfIndia", "http://timesofindia.indiatimes.com/rssfeedstopstories.cms");
        return map;
    }
}
