package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.TeamsDao;
import com.fsu.base.federationofsport.dao.LeaguesDao;
import com.fsu.base.federationofsport.model.Team;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ITeamsService;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamsService implements ITeamsService {

    private TeamsDao teamsDao;
    private IPlayersService playersService;
    private LeaguesDao leaguesDao;

    @Autowired
    public TeamsService(TeamsDao teamsDao,
                        IPlayersService playersService,
                        LeaguesDao leaguesDao) {
        this.teamsDao = teamsDao;
        this.playersService = playersService;
        this.leaguesDao = leaguesDao;
    }

    @Override
    public Team create(long leagueId,
                       Team team) {
        return create(leaguesDao.findOne(leagueId), team);
    }

    @Override
    public Team addPlayer(long leagueId, long teamId, Player player) {

        Team team = teamsDao.findOne(teamId);
        List<Player> players = team.getPlayers();
        players.add(player);

        team.setPlayers(players);


        return teamsDao.save(team);
    }

    @Override
    public Team create(League league, Team team) {
        team.setLeague(league);
        Team savedTeam = teamsDao.save(team);

        if (team.getPlayers().size() > 0) {
            savedTeam.setPlayers(
                    savePlayers(savedTeam, team.getPlayers()));
        }

        return savedTeam;
    }

    private List<Player> savePlayers(Team team, List<Player> players) {

        return players.stream()
                .map(player -> playersService.create(player))
                .collect(Collectors.toList());

    }

    @Override
    public Team getById(long id) {
        return teamsDao.findOne(id);
    }

    @Override
    public Iterable<Team> getAll() {
        return teamsDao.findAll();
    }

    @Override
    public Iterable<Team> getAllByLeague(long leagueId) {
        return teamsDao.findAllByLeague(leaguesDao.findOne(leagueId));
    }

    @Transactional
    @Override
    public void delete(long id) {
//        playersService.deleteAllByTeam(teamsDao.findOne(id));
        teamsDao.delete(id);
    }

    @Transactional
    @Override
    public void deleteAllByLeague(long leagueId) {

        League league = leaguesDao.findOne(leagueId);
//        playersService.deleteAllByLeague(league);
        teamsDao.deleteAllByLeague(league);
    }
}
