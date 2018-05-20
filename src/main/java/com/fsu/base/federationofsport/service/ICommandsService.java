package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;

public interface ICommandsService {

    Command create(long leagueId, Command command);

    Command create(League league, Command command);

    Command getById(long id);

    Iterable<Command> getAll();

    Iterable<Command> getAllByLeague(long leagueId);

    void delete(long id);

    void deleteAllByLeague(long leagueId);
}
