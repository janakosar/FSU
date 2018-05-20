package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;

public interface IPlayersService {

    Player create(Long commandId, Player player);

    Player create(Command command, Player player);

    Player getById(long id);

    Iterable<Player> getAll();

    Iterable<Player> getAllByCommand(long commandId);

    void delete(long id);

    void deleteAllByCommand(Command command);

    void deleteAllByLeague(League league);

}
