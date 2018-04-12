package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Video;
import com.fsu.base.federationofsport.model.VideoCategory;

/**
 * Created by yana on 12.04.18.
 */
public interface IVideosService {

    Iterable<Video> getAll();

    Iterable<Video> getAll(VideoCategory category);

    Video add(Video video);

    void delete(long id);
}
