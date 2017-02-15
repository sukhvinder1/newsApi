package com.news.architecture.util;

import com.news.architecture.Exceptions.NewsSystemException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by kbhatt on 1/17/2017.
 */
public class PropertyManager {

    @Autowired
    private Properties properties;

    @Autowired
    private Properties sourcesUrl;

    HashMap<String, String> propertiesMap = new HashMap<String, String>();

    public void loadProperties(){

        if (properties == null){
            throw new NewsSystemException("Null Properties Object");
        }

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }
    }

    public String getProperty(String name) {
        loadProperties();
        return propertiesMap.get(name);
    }

    public int propertiesSize() {

        loadProperties();
        int pSize = propertiesMap.size();

        return pSize;
    }

    public Enumeration getPropertyNames(){
        return properties.propertyNames();
    }

    private Enumeration getSourceUrlNames(){
        return sourcesUrl.propertyNames();
    }

    public HashMap<String, String> getUrlHashMap() {
        HashMap<String, String> map = new HashMap<>();
        Enumeration e = getSourceUrlNames();
        while (e.hasMoreElements()) {
            //getting the key
            String key = (String) e.nextElement();
            map.put(key, sourcesUrl.getProperty(key));
        }

        if (ValidationUtil.isMapNullOrEmpty(map)) {
            throw new NewsSystemException("Url hashMap is null");
        }

        return map;
    }

}