package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.CommandsDao;
import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.service.ICommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandsService implements ICommandsService {

    private CommandsDao commandsDao;

    @Autowired
    public CommandsService(CommandsDao commandsDao) {
        this.commandsDao = commandsDao;
    }

    @Override
    public Command create(Command command) {
        return commandsDao.save(command);
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
    public void delete(long id) {
        commandsDao.delete(id);
    }
}
