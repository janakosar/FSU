package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.PlayersDao;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayersService implements IPlayersService {

    private PlayersDao playersDao;

    @Autowired
    public PlayersService(PlayersDao playersDao) {
        this.playersDao = playersDao;
    }

    @Override
    public Player create(Player player) {
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
        playersDao.delete(id);
    }
}
