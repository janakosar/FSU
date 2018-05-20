package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.News;
import com.fsu.base.federationofsport.model.NewsCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yana on 12.04.18.
 */
public interface NewsDao extends CrudRepository<News, Long> {

    Iterable<News> findAllByCategory(NewsCategory category);
}
