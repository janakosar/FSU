package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Sponsor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yana on 12.04.18.
 */
public interface SponsorsDao extends CrudRepository<Sponsor, Long> {
}
