package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.CommandsDao;
import com.fsu.base.federationofsport.dao.PlayersDao;
import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ICommandsService;
import com.fsu.base.federationofsport.service.IPlayersService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayersService implements IPlayersService {

    private PlayersDao playersDao;
    private CommandsDao commandsDao;
    private StorageService storageService;

    @Autowired
    public PlayersService(PlayersDao playersDao,
                          CommandsDao commandsDao,
                          StorageService storageService) {
        this.playersDao = playersDao;
        this.commandsDao = commandsDao;
        this.storageService = storageService;
    }

    @Override
    public Player create(Long commandId, Player player) {

        return create(commandsDao.findOne(commandId), player);
    }

    @Override
    public Player create(Command command, Player player) {

        player.setCommand(command);
        player.setImage(storageService.store(player.getImage()));
        return playersDao.save(player);
    }

    @Override
    public Player getById(long id) {
        return playersDao.findOne(id);
    }

    @Override
    public Iterable<Player> getAll() {
        return playersDao.findAll();
    }

    @Override
    public Iterable<Player> getAllByCommand(long commandId) {
        return playersDao.findAllByCommand(commandsDao.findOne(commandId));
    }

    @Override
    public void delete(long id) {
        playersDao.delete(id);
    }

    @Transactional
    @Override
    public void deleteAllByCommand(Command command) {
        playersDao.deleteAllByCommand(command);
    }

    @Transactional
    @Override
    public void deleteAllByLeague(League league) {
        playersDao.deleteAllByCommandLeague(league);
    }
}
