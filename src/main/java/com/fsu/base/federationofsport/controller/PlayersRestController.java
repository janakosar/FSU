package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * - create
 * - remove
 * - get
 * - get all
 * - add to command
 * - add list to command
 * - remove from command
 * - get by command
 * - get all
 */
@RestController
@RequestMapping(path = "/api/")
public class PlayersRestController {

    private IPlayersService playersService;

    @Autowired
    public PlayersRestController(IPlayersService playersService) {
        this.playersService = playersService;
    }

    /**
     * Create player not related with any command or lique
     * @param player player to create
     * @return instance of created player
     */
    @PostMapping(path = "players")
    public Player create(@RequestBody Player player) {
        return playersService.create(player);
    }

    @DeleteMapping(path = "players/id")
    public void delete(@PathVariable Long id){
        playersService.delete(id);
    }

    @GetMapping(path = "players/{id}")
    public Player getById(@PathVariable Long id){
        return playersService.getById(id);
    }

    @GetMapping(path = "players")
    public Iterable<Player> getAll(){
        return playersService.getAll();
    }

    @GetMapping(path = "commands/{commandId}/players")
    public Iterable<Player> getAllByCommand(@PathVariable Long commandId){
        return playersService.getAllByCommand(commandId);
    }

}
