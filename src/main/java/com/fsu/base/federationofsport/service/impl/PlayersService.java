package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.PlayersDao;
import com.fsu.base.federationofsport.dao.TeamsDao;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.model.Team;
import com.fsu.base.federationofsport.service.IPlayersService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayersService implements IPlayersService {

    private PlayersDao playersDao;
    private StorageService storageService;
    private TeamsDao teamsDao;


    @Autowired
    public PlayersService(PlayersDao playersDao,
                          TeamsDao teamsDao,
                          StorageService storageService) {
        this.playersDao = playersDao;
        this.teamsDao = teamsDao;
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
        teamsDao.findAllByPlayers(Collections.singletonList(getById(id)))
                .forEach(team -> {
                    List<Player> players = team.getPlayers().stream()
                            .filter(player -> player.getId() != id)
                            .collect(Collectors.toList());

                    team.setPlayers(players);

                    teamsDao.save(team);
                });
        playersDao.delete(id);
    }
}
