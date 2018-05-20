package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.controller.ImagesRestController;
import com.fsu.base.federationofsport.dao.NewsDao;
import com.fsu.base.federationofsport.model.News;
import com.fsu.base.federationofsport.model.NewsCategory;
import com.fsu.base.federationofsport.service.INewsService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

/**
 * Created by yana on 12.04.18.
 */
@Service
public class NewsService implements INewsService {

    private NewsDao newsDao;
    private StorageService storageService;


    @Autowired
    public NewsService(NewsDao newsDao,
                       StorageService storageService) {
        this.newsDao = newsDao;
        this.storageService = storageService;
    }

    @Override
    public Iterable<News> getAll() {
        return newsDao.findAll();
    }

    @Override
    public Iterable<News> getByCategory(String category) {
        return newsDao.findAllByCategory(NewsCategory.valueOf(category.toUpperCase()));
    }

    @Override
    public News get(long id) {
        return newsDao.findOne(id);
    }

    @Override
    public News add(News news) {

        news.setImage(storageService.store(news.getImage()));

        return newsDao.save(news);

    }

    @Override
    public void delete(long id) {
        newsDao.delete(id);
    }
}
