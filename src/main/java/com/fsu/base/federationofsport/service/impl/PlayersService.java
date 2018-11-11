package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.PlayersDao;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.IPlayersService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayersService implements IPlayersService {

    private PlayersDao playersDao;
    private StorageService storageService;
    private TeamsService teamsService;


    @Autowired
    public PlayersService(PlayersDao playersDao,
                          StorageService storageService) {
        this.playersDao = playersDao;
        this.storageService = storageService;
    }

    @Override
    public Player create(Player player) {
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
    public void delete(long id) {
        teamsService.removePlayerFromAllTeams(id);
        playersDao.delete(id);
    }
}
