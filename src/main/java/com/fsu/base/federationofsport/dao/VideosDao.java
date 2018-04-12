package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Video;
import com.fsu.base.federationofsport.model.VideoCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yana on 12.04.18.
 */
public interface VideosDao extends CrudRepository<Video, Long>{

    Iterable<Video> findAll(VideoCategory category);
}
