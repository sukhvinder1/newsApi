package com.news.application.facade.mapper;

import com.news.application.facade.dto.CategoriesDto;
import com.news.architecture.util.PropertyManager;
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

import static org.mockito.Mockito.when;

/**
 * Created by sukh on 2017-01-15.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriesMapperTest {

    @InjectMocks
    private CategoriesMapper mapper;

    @Mock
    private PropertyManager propertyManager;

    private Hashtable<String,String> hashtable;

    @Before
    public void setup(){
        when(propertyManager.getPropertyNames()).thenReturn(prepareEnumration());
        when(propertyManager.getProperty("tech.cnn")).thenReturn(hashtable.get("tech.cnn"));
        when(propertyManager.getProperty("top.bbc")).thenReturn(hashtable.get("top.bbc"));
        when(propertyManager.getProperty("tech.mashable")).thenReturn(hashtable.get("tech.mashable"));
        when(propertyManager.getProperty("sports.espn")).thenReturn(hashtable.get("sports.espn"));
        when(propertyManager.getProperty("business.huffingtonPost")).thenReturn(hashtable.get("business.huffingtonPost"));
        when(propertyManager.getProperty("entertainment.hollywoodReporter")).thenReturn(hashtable.get("entertainment.hollywoodReporter"));
        when(propertyManager.getProperty("finance.ft")).thenReturn(hashtable.get("finance.ft"));
        when(propertyManager.getProperty("local.torontoSun")).thenReturn(hashtable.get("local.torontoSun"));
    }

    @Test
    public void test(){
        List<CategoriesDto> response = mapper.prepareDto();
        Assert.assertEquals("cnn-tech", response.get(0).getSources().get(0));
        Assert.assertEquals("bbc", response.get(1).getSources().get(0));
        Assert.assertEquals("mashable", response.get(0).getSources().get(1));
        Assert.assertEquals("espn", response.get(2).getSources().get(0));
        Assert.assertEquals("huffingtonPost", response.get(3).getSources().get(0));
        Assert.assertEquals("hollywoodReporter", response.get(5).getSources().get(0));
        Assert.assertEquals("ft", response.get(4).getSources().get(0));
        Assert.assertEquals("torontoSun", response.get(6).getSources().get(0));

    }

    private Enumeration prepareEnumration(){
        hashtable = new Hashtable<>();
        hashtable.put("tech.cnn", "cnn-tech");
        hashtable.put("top.bbc", "bbc");
        hashtable.put("tech.mashable", "mashable");
        hashtable.put("business.huffingtonPost", "mashable");
        hashtable.put("sports.espn","espn");
        hashtable.put("business.huffingtonPost","huffingtonPost");
        hashtable.put("entertainment.hollywoodReporter","hollywoodReporter");
        hashtable.put("finance.ft","ft");
        hashtable.put("local.torontoSun","torontoSun");
        return hashtable.keys();
    }
}
