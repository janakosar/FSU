package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Player;

public interface IPlayersService {

    Player create(Player player);

    Player getById(long id);

    Iterable<Player> getAll();

    void delete(long id);

}
