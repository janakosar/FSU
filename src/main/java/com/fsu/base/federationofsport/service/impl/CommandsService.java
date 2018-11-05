package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.CommandsDao;
import com.fsu.base.federationofsport.dao.LeaguesDao;
import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Passport;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ICommandsService;
import com.fsu.base.federationofsport.service.ILeaguesService;
import com.fsu.base.federationofsport.service.IPassportsService;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandsService implements ICommandsService {

    private CommandsDao commandsDao;
    private IPassportsService playersService;
    private LeaguesDao leaguesDao;

    @Autowired
    public CommandsService(CommandsDao commandsDao,
                           IPassportsService playersService,
                           LeaguesDao leaguesDao) {
        this.commandsDao = commandsDao;
        this.playersService = playersService;
        this.leaguesDao = leaguesDao;
    }

    @Override
    public Command create(long leagueId,
                          Command command) {
        return create(leaguesDao.findOne(leagueId), command);
    }

    @Override
    public Command addPlayer(long leagueId, long commandId, Passport player) {

        Command command = commandsDao.findOne(commandId);
        player.setCommand(command);

        playersService.create(player);

        return commandsDao.findOne(commandId);
    }

    @Override
    public Command create(League league, Command command) {
        command.setLeague(league);
        Command savedCommand = commandsDao.save(command);

        if (command.getPassports().size() > 0) {
            savedCommand.setPassports(
                    savePlayers(savedCommand, command.getPassports()));
        }

        return savedCommand;
    }

    private List<Passport> savePlayers(Command command, List<Passport> players) {

        return players.stream()
                .map(player -> playersService.create(player))
                .collect(Collectors.toList());

    }

    @Override
    public Command getById(long id) {
        return commandsDao.findOne(id);
    }

    @Override
    public Iterable<Command> getAll() {
        return commandsDao.findAll();
    }

    @Override
    public Iterable<Command> getAllByLeague(long leagueId) {
        return commandsDao.findAllByLeague(leaguesDao.findOne(leagueId));
    }

    @Transactional
    @Override
    public void delete(long id) {
//        playersService.deleteAllByCommand(commandsDao.findOne(id));
        commandsDao.delete(id);
    }

    @Transactional
    @Override
    public void deleteAllByLeague(long leagueId) {

        League league = leaguesDao.findOne(leagueId);
//        playersService.deleteAllByLeague(league);
        commandsDao.deleteAllByLeague(league);
    }
}
