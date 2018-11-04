package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesDao extends CrudRepository<Image, Long> {
}
