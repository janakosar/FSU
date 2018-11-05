package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Command;
import com.fsu.base.federationofsport.model.League;
import com.fsu.base.federationofsport.service.ILeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/leagues")
public class LeaguesRestController {

    private ILeaguesService leaguesService;

    @Autowired
    public LeaguesRestController(ILeaguesService leaguesService) {
        this.leaguesService = leaguesService;
    }

    @PostMapping
    public League create(@RequestBody League league) {
        return leaguesService.create(league);
    }

    @PostMapping(path = "/{id}/teams")
    public League addTeam(@PathVariable Long id,
                          @RequestBody Command team) {
        return leaguesService.addTeam(id, team);
    }

    @GetMapping(path = "/{id}")
    public League getById(@PathVariable Long id){
        return leaguesService.getById(id);
    }

    @GetMapping
    public Iterable<League> getAll(){
        return leaguesService.getAll();
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        leaguesService.delete(id);
    }
}
