package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.VideosDao;
import com.fsu.base.federationofsport.model.Video;
import com.fsu.base.federationofsport.model.VideoCategory;
import com.fsu.base.federationofsport.service.IVideosService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yana on 12.04.18.
 */
public class VideosService implements IVideosService {

    private VideosDao videosDao;

    @Autowired
    VideosService(VideosDao videosDao) {
        this.videosDao = videosDao;
    }

    @Override
    public Iterable<Video> getAll() {
        return videosDao.findAll();
    }

    @Override
    public Iterable<Video> getAll(VideoCategory category) {
        return videosDao.findAll(category);
    }

    @Override
    public Video add(Video video) {
        return videosDao.save(video);
    }

    @Override
    public void delete(long id) {
        videosDao.delete(id);
    }
}
