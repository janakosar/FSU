package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandsDao  extends CrudRepository<Command, Long> {
}
