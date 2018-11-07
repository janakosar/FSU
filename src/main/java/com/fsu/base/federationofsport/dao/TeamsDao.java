package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Team;
import com.fsu.base.federationofsport.model.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsDao extends CrudRepository<Team, Long> {

    void deleteAllByLeague(League league);

    Iterable<Team> findAllByLeague(League league);
}
