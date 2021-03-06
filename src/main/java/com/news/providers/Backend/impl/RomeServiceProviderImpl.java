package com.news.providers.Backend.impl;

import com.news.application.facade.constant.AppConstant;
import com.news.application.facade.dto.Sources;
import com.news.architecture.Exceptions.NewsSystemException;
import com.news.architecture.util.PropertyManager;
import com.news.architecture.util.ValidationUtil;
import com.news.providers.Backend.RomeServiceProvider;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.apache.log4j.Logger;

import javax.inject.Inject;

import org.jdom.Element;

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

    Logger logger = Logger.getLogger(RomeServiceProviderImpl.class);

    private static final String URL = "url";
    private static final String SRCINDEX = "src=";
    private static final String STARTINDEX = "h";
    private static final char ENDINDEX = '"';
    private static final String FORWARDSLASH = "/";

    @Override
    public ConcurrentHashMap<String, List<Sources>> getAllArticles() {

        ConcurrentHashMap<String, List<Sources>> allArticlesMap = new ConcurrentHashMap<>();
        HashMap<String, String> urlMap = propertyManager.getUrlHashMap();

        for (String urlKey : urlMap.keySet()) {
            allArticlesMap.put(urlKey, prepareDO(getFeed(urlMap.get(urlKey)), urlKey));
        }

        return allArticlesMap;
    }

    private List<Sources> prepareDO(SyndFeed feed, String key) {
        List<Sources> sourcesArrayList = new ArrayList<>();

        if (feed == null) {
            throw new NewsSystemException("feed is null");
        }

        List<SyndEntry> items = feed.getEntries();
        if (items != null) {
            //TODO date logic still pending
            for (SyndEntry item : items) {

                String imgURL = null;
                if (key.equalsIgnoreCase(AppConstant.THEVERGE) || key.equalsIgnoreCase(AppConstant.TECHNEWSWORLD)) {
                    imgURL = getImageFromContent(item.getContents().get(0).toString());
                } else if(key.equalsIgnoreCase(AppConstant.TIMESOFINDIA)) {
                    imgURL = getTimesOfIndiaImage(item.getLink());
                } else {

                    List<Element> foreignMarkups = (List<Element>) item.getForeignMarkup();

                    for (Element foreignMarkup : foreignMarkups) {
                        if (!(foreignMarkup.getAttribute(URL) == null)) {
                            imgURL = foreignMarkup.getAttribute(URL).getValue();
                        }
                    }
                    if (imgURL == null) {
                        List<SyndEnclosure> encls = item.getEnclosures();
                        if (!encls.isEmpty()) {
                            for (SyndEnclosure e : encls) {
                                imgURL = e.getUrl().toString();
                            }
                        }
                    }
                }

                Sources sources = new Sources();
                sources.setTitle(item.getTitle());
                sources.setUrl(item.getLink());
                sources.setImageUrl(imgURL);
                sources.setDate(item.getPublishedDate());
                sourcesArrayList.add(sources);
            }
        }

        if (ValidationUtil.isCollectionNullOrEmpty(sourcesArrayList)) {
            String message = "List of sources are empty at Rome provider";
            logger.error(message);
            throw new NewsSystemException(message);
        }

        return sourcesArrayList;
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
            logger.error(ex);
            throw new NewsSystemException(ex.getMessage());
        }

        if (feed == null) {
            throw new NewsSystemException("SyndFeed is null at Rome Provider");
        }

        return feed;
    }

    public String getImageFromContent(String content) {
        int srcIndex = content.indexOf(SRCINDEX);
        int startIndex = content.indexOf(STARTINDEX, srcIndex);
        int endIndex = content.indexOf(ENDINDEX, startIndex);
        String s = content.substring(startIndex, endIndex);
        return s;
    }

    public String getTimesOfIndiaImage(String articleUrl){

        String str = articleUrl;
        int index = str.lastIndexOf(FORWARDSLASH);
        String articleId=(str.substring(index +1));
        String imageURL = AppConstant.TIMESOFINDIADOMAIN + articleId;
        return imageURL;

    }

}
