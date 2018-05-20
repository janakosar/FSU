package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.LeaguesDao;
import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.service.ICommandsService;
import com.fsu.base.federationofsport.service.ILeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaguesService implements ILeaguesService {

    private LeaguesDao leaguesDao;
    private ICommandsService commandsService;

    @Autowired
    public LeaguesService(LeaguesDao leaguesDao,
                          ICommandsService commandsService) {
        this.leaguesDao = leaguesDao;
        this.commandsService = commandsService;
    }

    @Override
    public League create(League league) {
        League savedLeague = leaguesDao.save(league);

        if (savedLeague.getCommands().size() > 0) {
            savedLeague.setCommands(saveCommands(savedLeague, league.getCommands()));
        }

        return savedLeague;
    }

    private List<Command> saveCommands(League league, List<Command> commands) {

        return commands.stream()
                .map(command -> commandsService.create(league, command))
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
        commandsService.deleteAllByLeague(id);
        leaguesDao.delete(id);
    }
}
