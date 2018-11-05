package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;

public interface ILeaguesService {

    League create(League league);

    League addTeam(long leagueId, Command command);

    League getById(long id);

    Iterable<League> getAll();

    void delete(long id);

}
