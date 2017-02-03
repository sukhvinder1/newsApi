package com.news.providers.Backend;

import com.news.application.facade.dto.Sources;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukh on 2017-01-21.
 */
public interface RomeServiceProvider {

    ConcurrentHashMap<String, List<Sources>> getAllArticles();
}
