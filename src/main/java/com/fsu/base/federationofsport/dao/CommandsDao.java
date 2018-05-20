package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandsDao  extends CrudRepository<Command, Long> {

    void deleteAllByLeague(League league);

    Iterable<Command> findAllByLeague(League league);
}
