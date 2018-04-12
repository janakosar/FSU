package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.VideosDao;
import com.fsu.base.federationofsport.model.Video;
import com.fsu.base.federationofsport.service.IVideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yana on 12.04.18.
 */
@Service
public class VideosService implements IVideosService {

    private VideosDao videosDao;

    @Autowired
    public VideosService(VideosDao videosDao) {
        this.videosDao = videosDao;
    }

    @Override
    public Iterable<Video> getAll() {
        return videosDao.findAll();
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
