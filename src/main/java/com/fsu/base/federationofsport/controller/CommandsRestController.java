package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.Passport;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ICommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/")
public class CommandsRestController {

    private ICommandsService commandsService;

    @Autowired
    public CommandsRestController(ICommandsService commandsService) {
        this.commandsService = commandsService;
    }

    @PostMapping(path = "leagues/{leagueId}/commands")
    public Command create(@PathVariable Long leagueId,
                          @RequestBody Command command) {
        return commandsService.create(leagueId, command);
    }

    @GetMapping(path = "commands/{id}")
    public Command getById(@PathVariable Long id){
        return commandsService.getById(id);
    }


    @GetMapping(path = "leagues/{leagueId}/commands")
    public
    Iterable<Command> getByLeague(@PathVariable Long leagueId){
        return commandsService.getAllByLeague(leagueId);
    }

    @PostMapping(path = "leagues/{leagueId}/teams/{commandId}/players")
    public
    Command addPlayer(@PathVariable Long leagueId,
                      @PathVariable Long commandId,
                      @RequestBody Passport player){
        return commandsService.addPlayer(leagueId, commandId, player);
    }


    @GetMapping(path = "commands")
    public Iterable<Command> getAll(){
        return commandsService.getAll();
    }

    @DeleteMapping(path = "commands/{id}")
    public void delete(@PathVariable Long id){
        commandsService.delete(id);
    }
}
