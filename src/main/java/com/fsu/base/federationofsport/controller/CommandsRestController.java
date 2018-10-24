package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ICommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class CommandsRestController {

    private ICommandsService commandsService;

    @Autowired
    public CommandsRestController(ICommandsService commandsService) {
        this.commandsService = commandsService;
    }

    /**
     * Create command and map it with certain league
     * @param leagueId id of league
     * @param command command to create and add to league
     * @return instance of created command
     */
    @PostMapping(path = "leagues/{leagueId}/commands")
    public Command create(@PathVariable Long leagueId,
                          @RequestBody Command command) {
        return commandsService.create(leagueId, command);
    }

    /**
     * @param id id of command
     * @return command with requested id
     */
    @GetMapping(path = "commands/{id}")
    public Command getById(@PathVariable Long id){
        return commandsService.getById(id);
    }

    @PostMapping(path = "commands/{commandId}/players/add/{playerId}")
    public Player addPlayer(@PathVariable Long commandId,
                            @PathVariable Long playerId) {
        return commandsService.addPlayer(commandId, playerId);
    }

    @PostMapping(path = "commands/{commandId}/players/add/{playerId}")
    public List<Player> addPlayers(@PathVariable Long commandId,
                                   @RequestBody List<Long> playerIds) {
        return commandsService.addPlayers(commandId, playerIds);
    }

    @GetMapping(path = "leagues/{leagueId}/commands")
    public
    Iterable<Command> getByLeague(@PathVariable Long leagueId){
        return commandsService.getAllByLeague(leagueId);
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
