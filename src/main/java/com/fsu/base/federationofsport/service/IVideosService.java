package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Video;

/**
 * Created by yana on 12.04.18.
 */
public interface IVideosService {

    Iterable<Video> getAll();

    Video add(Video video);

    void delete(long id);
}
