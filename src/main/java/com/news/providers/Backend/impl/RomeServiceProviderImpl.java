package com.news.providers.Backend.impl;

import com.news.application.facade.dto.Sources;
import com.news.architecture.Exceptions.NewsSystemException;
import com.news.architecture.util.PropertyManager;
import com.news.architecture.util.ValidationUtil;
import com.news.providers.Backend.RomeServiceProvider;
import com.news.providers.Entity.RomeDO;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import javax.inject.Inject;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-21.
 */
public class RomeServiceProviderImpl implements RomeServiceProvider {

    @Inject
    private PropertyManager propertyManager;

    @Override
    public ConcurrentHashMap<String, List<Sources>> getAllArticles() {

        ConcurrentHashMap<String, List<Sources>> allArticlesMap = new ConcurrentHashMap<>();
        HashMap<String, String> urlMap = propertyManager.getUrlHashMap();

        for (String urlKey : urlMap.keySet()) {
            allArticlesMap.put(urlKey, prepareDO(getFeed(urlMap.get(urlKey))));
        }

        return allArticlesMap;
    }

    private SyndFeed getFeed(String url) {

        if (url == null || url.isEmpty()) {
            throw new NewsSystemException("url is null or empty");
        }

        SyndFeed feed = null;
        try {
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new NewsSystemException(ex.getMessage());
        }

        if (feed == null) {
            throw new NewsSystemException("SyndFeed is null at Rome Provider");
        }

        return feed;
    }

    private List<Sources> prepareDO(SyndFeed feed) {
        List<Sources> sourcesArrayList = new ArrayList<>();

        if (feed == null) {
            throw new NewsSystemException("feed is null");
        }

        List<SyndEntry> items = feed.getEntries();
        if (items != null) {
            //TODO date logic still pending
            for (SyndEntry item : items) {
                Sources sources = new Sources();
                sources.setTitle(item.getTitle());
                sources.setUrl(item.getLink());
                sources.setImageUrl("null");
                sources.setDate(item.getPublishedDate());
                sourcesArrayList.add(sources);
            }
        }

        if (ValidationUtil.isCollectionNullOrEmpty(sourcesArrayList)) {
            throw new NewsSystemException("List of sources are empty at Rome provider");
        }

        return sourcesArrayList;
    }
}
