package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.News;
import com.fsu.base.federationofsport.model.NewsCategory;

/**
 * Created by yana on 12.04.18.
 */
public interface INewsService {

    Iterable<News> getAll();

    Iterable<News> getByCategory(NewsCategory category);

    News get(long id);

    News add(News news);

    void delete(long id);
}
