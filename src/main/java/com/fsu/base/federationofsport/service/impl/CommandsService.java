package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.CommandsDao;
import com.fsu.base.federationofsport.dao.LeaguesDao;
import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ICommandsService;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommandsService implements ICommandsService {

    private CommandsDao commandsDao;
    private IPlayersService playersService;
    private LeaguesDao leaguesDao;

    @Autowired
    public CommandsService(CommandsDao commandsDao,
                           IPlayersService playersService,
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
    public Command create(League league, Command command) {
        command.setLeague(league);
        Command savedCommand = commandsDao.save(command);

        if (command.getPlayers().size() > 0) {
            savedCommand.setPlayers(
                    savePlayers(savedCommand, command.getPlayers()));
        }

        return savedCommand;
    }

    @Override
    public Player addPlayer(long commandId, long playerId) {

        Command command = commandsDao.findOne(commandId);
        Player player = playersService.getById(playerId);

        Set<Command> commands = player.getCommands();

        if (!commands.contains(command)) {
            commands.add(command);
            player.setCommands(commands);
        }
        return playersService.create(player);
    }

    @Override
    public List<Player> addPlayers(long commandId, List<Long> playerIds) {

        Command command = commandsDao.findOne(commandId);

        return playerIds.
                stream()
                .map(playerId -> playersService.getById(playerId))
                .peek(player -> {
                    Set<Command> commands = player.getCommands();

                    if (!commands.contains(command)) {
                        commands.add(command);
                        player.setCommands(commands);
                    }

                }).collect(Collectors.toList());

    }

    private List<Player> savePlayers(Command command, List<Player> players) {

        return players.stream()
                .map(player -> playersService.create(command, player))
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
        playersService.deleteAllByCommand(commandsDao.findOne(id));
        commandsDao.delete(id);
    }

    @Transactional
    @Override
    public void deleteAllByLeague(long leagueId) {

        League league = leaguesDao.findOne(leagueId);
        playersService.deleteAllByLeague(league);
        commandsDao.deleteAllByLeague(league);
    }
}
