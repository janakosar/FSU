package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Team;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;

public interface ITeamsService {

    Team create(long leagueId, Team team);

    Team create(League league, Team team);

    Team addPlayer(long leagueId, long teamId, Player player);

    Team removePlayer(long teamId, long playerId);

    void removePlayerFromAllTeams(long playerId);

    void removeAllPlayersFromTeam(long teamId);

    Team getById(long id);

    Iterable<Team> getAll();

    Iterable<Team> getAllByLeague(long leagueId);

    void delete(long id);

    void deleteAllByLeague(long leagueId);
}
