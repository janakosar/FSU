package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/")
public class PlayersRestController {

    private IPlayersService playersService;

    @Autowired
    public PlayersRestController(IPlayersService playersService) {
        this.playersService = playersService;
    }

    @PostMapping(path = "commands/{commandId}/players")
    public Player create(@PathVariable Long commandId, @RequestBody Player player) {
        return playersService.create(commandId, player);
    }

    @GetMapping(path = "players/{id}")
    public Player getById(@PathVariable Long id){
        return playersService.getById(id);
    }

    @GetMapping(path = "players")
    public Iterable<Player> getAll(){
        return playersService.getAll();
    }

//    @GetMapping(path = "commands/{commandId}/players")
//    public Iterable<Player> getAllByCommand(@PathVariable Long commandId){
//        return playersService.getAllByCommand(commandId);
//    }

    @DeleteMapping(path = "players/id")
    public void delete(@PathVariable Long id){
        playersService.delete(id);
    }
}
