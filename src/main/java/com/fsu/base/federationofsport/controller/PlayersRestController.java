package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.IPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/players")
public class PlayersRestController {

    private IPlayersService playersService;

    @Autowired
    public PlayersRestController(IPlayersService playersService) {
        this.playersService = playersService;
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return playersService.create(player);
    }

    @GetMapping(path = "/{id}")
    public Player getById(@PathVariable Long id){
        return playersService.getById(id);
    }

    @GetMapping
    public Iterable<Player> getAll(){
        return playersService.getAll();
    }

    @DeleteMapping(path = "/id")
    public void delete(@PathVariable Long id){
        playersService.delete(id);
    }
}
