package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaguesDao extends CrudRepository<League, Long> {
}
