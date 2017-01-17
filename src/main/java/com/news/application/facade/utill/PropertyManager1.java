package com.news.application.facade.utill;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Properties;

/**
 * Created by kbhatt on 1/17/2017.
 */
public class PropertyManager1 {

    @Autowired
    private Properties properties;

    HashMap<String, String> propertiesMap = new HashMap<String, String>();

    public void loadProperties(){
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



}