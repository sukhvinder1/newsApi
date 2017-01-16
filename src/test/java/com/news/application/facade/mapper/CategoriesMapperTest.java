package com.news.application.facade.mapper;

import com.news.application.facade.dto.CategoriesDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import static org.mockito.Mockito.when;

/**
 * Created by sukh on 2017-01-15.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriesMapperTest {

    @InjectMocks
    private CategoriesMapper mapper;

    @Mock
    private Properties properties;

    private Hashtable<String,String> hashtable;

    @Before
    public void setup(){
        when(properties.propertyNames()).thenReturn(prepareEnumration());
        when(properties.getProperty("tech.cnn")).thenReturn(hashtable.get("tech.cnn"));
        when(properties.getProperty("top.bbc")).thenReturn(hashtable.get("top.bbc"));
        when(properties.getProperty("tech.mashable")).thenReturn(hashtable.get("tech.mashable"));
    }

    @Test
    public void test(){
        List<CategoriesDto> response = mapper.prepareDto();
        Assert.assertEquals("cnn-tech", response.get(0).getSources().get(0));
        Assert.assertEquals("bbc", response.get(1).getSources().get(0));
        Assert.assertEquals("mashable", response.get(0).getSources().get(1));
    }

    private Enumeration prepareEnumration(){
        hashtable = new Hashtable<>();
        hashtable.put("tech.cnn", "cnn-tech");
        hashtable.put("top.bbc", "bbc");
        hashtable.put("tech.mashable", "mashable");
        return hashtable.keys();
    }
}