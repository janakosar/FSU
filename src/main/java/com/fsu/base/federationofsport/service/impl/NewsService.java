package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.NewsDao;
import com.fsu.base.federationofsport.model.News;
import com.fsu.base.federationofsport.model.NewsCategory;
import com.fsu.base.federationofsport.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yana on 12.04.18.
 */
public class NewsService implements INewsService {

    private NewsDao newsDao;

    @Autowired
    NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public Iterable<News> getAll() {
        return newsDao.findAll();
    }

    @Override
    public Iterable<News> getAll(NewsCategory category) {
        return newsDao.findAll(category);
    }

    @Override
    public News get(long id) {
        return newsDao.findOne(id);
    }

    @Override
    public News add(News news) {
        return newsDao.save(news);
    }

    @Override
    public void delete(long id) {
        newsDao.delete(id);
    }
}
