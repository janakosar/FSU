package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Command;

public interface ICommandsService {

    Command create(Command command);

    Command getById(long id);

    Iterable<Command> getAll();

    void delete(long id);

}
