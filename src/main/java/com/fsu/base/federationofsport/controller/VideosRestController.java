package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Video;
import com.fsu.base.federationofsport.model.VideoCategory;
import com.fsu.base.federationofsport.service.IVideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "/api/v1/videos")
public class VideosRestController {

    private IVideosService videosService;

    @Autowired
    VideosRestController(IVideosService videosService){
        this.videosService =videosService;
    }

    @GetMapping
    Iterable<Video> getAll() {
        return videosService.getAll();
    }


    @PostMapping(path = "/create")
    Video add(@RequestBody Video video){

        return videosService.add(video);
    }

    @DeleteMapping(path = "/delete/{id}")
    void  delete(@PathVariable Long id){
        videosService.delete(id);
    }

}
