package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersDao  extends CrudRepository<Player, Long> {

    Iterable<Player> findAllByCommand(Command command);

    void deleteAllByCommand(Command command);

    void deleteAllByCommandLeague(League league);
}
