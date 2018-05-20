package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.News;
import com.fsu.base.federationofsport.model.NewsCategory;
import com.fsu.base.federationofsport.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "/api/news")
public class NewsRestController {

    private INewsService newsService;

    @Autowired
    NewsRestController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    Iterable<News> getAll() {
        return newsService.getAll();
    }

//    @GetMapping(path = "/{category}")
//    Iterable<News> getAll(@PathVariable NewsCategory category){
//
//        return newsService.getAll(category);
//    }

    @GetMapping(path = "/{id}")
    News get(@PathVariable Long id){

        return newsService.get(id);
    }

    @PostMapping
    News add(@RequestBody News news){

        return newsService.add(news);
    }

    @DeleteMapping(path = "/{id}")
    void  delete(@PathVariable Long id){
        newsService.delete(id);
    }

}
