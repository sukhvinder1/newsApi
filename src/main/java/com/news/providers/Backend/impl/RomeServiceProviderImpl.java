package com.news.providers.Backend.impl;

import com.news.architecture.Exceptions.NewsSystemException;
import com.news.providers.Backend.RomeServiceProvider;
import com.news.providers.Entity.RomeDO;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukh on 2017-01-21.
 */
public class RomeServiceProviderImpl implements RomeServiceProvider {

    @Override
    public List<RomeDO> getRomeDO(String url) {
        return prepareDO(getFeed(url));
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

        return feed;
    }

    private List<RomeDO> prepareDO(SyndFeed feed) {
        List<RomeDO> romeDOList = new ArrayList<>();

        if (feed == null) {
            throw new NewsSystemException("feed is null");
        }

        List<SyndEntry> items = feed.getEntries();
        if (items != null) {
            for (SyndEntry item : items) {
                RomeDO romeDO = new RomeDO();
                romeDO.setTitle(item.getTitle().toString());
                romeDO.setUrl(item.getLink().toString());
                romeDO.setImageUrl("null");
                romeDO.setDate(item.getPublishedDate());
                romeDOList.add(romeDO);
            }
        }

        return romeDOList;
    }
}
