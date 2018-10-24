package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;

import java.util.List;

public interface ICommandsService {

    Command create(long leagueId, Command command);

    Command create(League league, Command command);

    Command getById(long id);

    Player addPlayer(long commandId, long playerId);

    List<Player> addPlayers(long commandId, List<Long> playerIds);

    Iterable<Command> getAll();

    Iterable<Command> getAllByLeague(long leagueId);

    void delete(long id);

    void deleteAllByLeague(long leagueId);
}
