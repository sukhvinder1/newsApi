package com.news.architecture.config;

import com.news.application.facade.ArticlesFacade;
import com.news.application.facade.CategoryFacade;
import com.news.application.facade.impl.ArticlesFacadeImpl;
import com.news.application.facade.impl.CategoryFacadeImpl;
import com.news.application.facade.mapper.CategoriesMapper;
import com.news.application.facade.util.SortArticles;
import com.news.architecture.util.PropertyManager;
import com.news.providers.Backend.RomeServiceProvider;
import com.news.providers.Backend.impl.DataHub;
import com.news.providers.Backend.impl.RomeServiceProviderImpl;
import com.news.providers.Backend.impl.ScheduledService;
import com.news.providers.impl.CommonNewsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sukh on 2017-02-16.
 */
@Configuration
public class AppConfig {

    @Bean
    public CategoryFacade categoryFacade() {
        return new CategoryFacadeImpl();
    }

    @Bean
    public ArticlesFacade articlesFacade() {
        return new ArticlesFacadeImpl();
    }

    @Bean
    public CategoriesMapper categoriesMapper() {
        return new CategoriesMapper();
    }

    @Bean
    public PropertyManager propertyManager() {
        return new PropertyManager();
    }

    @Bean
    public SortArticles sortArticles() {
        return new SortArticles();
    }

    @Bean
    public CommonNewsProvider commonNewsProvider() {
        return new CommonNewsProvider();
    }

    @Bean
    public RomeServiceProvider romeServiceProvider() {
        return new RomeServiceProviderImpl();
    }

    @Bean
    public ScheduledService scheduledService() {
        return new ScheduledService();
    }

    @Bean
    public DataHub dataHub() {
        return new DataHub();
    }
}
