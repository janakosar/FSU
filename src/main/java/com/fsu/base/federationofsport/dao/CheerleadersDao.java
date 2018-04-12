package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Cheerleader;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yana on 12.04.18.
 */
public interface CheerleadersDao extends CrudRepository<Cheerleader, Long> {
}
