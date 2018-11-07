package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersDao extends CrudRepository<Player, Long> {
}

