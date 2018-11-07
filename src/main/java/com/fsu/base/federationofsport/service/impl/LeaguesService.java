package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.LeaguesDao;
import com.fsu.base.federationofsport.model.Team;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.service.ITeamsService;
import com.fsu.base.federationofsport.service.ILeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaguesService implements ILeaguesService {

    private LeaguesDao leaguesDao;
    private ITeamsService teamsService;

    @Autowired
    public LeaguesService(LeaguesDao leaguesDao,
                          ITeamsService teamsService) {
        this.leaguesDao = leaguesDao;
        this.teamsService = teamsService;
    }

    @Override
    public League create(League league) {
        League savedLeague = leaguesDao.save(league);

        if (savedLeague.getTeams().size() > 0) {
            savedLeague.setTeams(saveTeams(savedLeague, league.getTeams()));
        }

        return savedLeague;
    }

    @Override
    public League addTeam(long leagueId, Team team) {
        teamsService.create(leaguesDao.findOne(leagueId), team);
        return leaguesDao.findOne(leagueId);
    }

    private List<Team> saveTeams(League league, List<Team> teams) {

        return teams.stream()
                .map(team -> teamsService.create(league, team))
                .collect(Collectors.toList());
    }

    @Override
    public League getById(long id) {
        return leaguesDao.findOne(id);
    }

    @Override
    public Iterable<League> getAll() {
        return leaguesDao.findAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        teamsService.deleteAllByLeague(id);
        leaguesDao.delete(id);
    }
}
