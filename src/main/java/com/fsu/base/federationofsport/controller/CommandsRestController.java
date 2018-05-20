package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.service.ICommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/commands")
public class CommandsRestController {

    private ICommandsService commandsService;

    @Autowired
    public CommandsRestController(ICommandsService commandsService) {
        this.commandsService = commandsService;
    }

    @PostMapping
    public Command create(@RequestBody Command command) {
        return commandsService.create(command);
    }

    @GetMapping(path = "/{id}")
    public Command getById(@PathVariable Long id){
        return commandsService.getById(id);
    }

    @GetMapping
    public Iterable<Command> getAll(){
        return commandsService.getAll();
    }

    @DeleteMapping(path = "/id")
    public void delete(@PathVariable Long id){
        commandsService.delete(id);
    }
}
