package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Team;
import com.fsu.base.federationofsport.model.Player;
import com.fsu.base.federationofsport.service.ITeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/")
public class TeamsRestController {

    private ITeamsService teamsService;

    @Autowired
    public TeamsRestController(ITeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping(path = "teams/{id}")
    public Team getById(@PathVariable Long id){
        return teamsService.getById(id);
    }


    @GetMapping(path = "leagues/{leagueId}/teams")
    public
    Iterable<Team> getByLeague(@PathVariable Long leagueId){
        return teamsService.getAllByLeague(leagueId);
    }

    @PostMapping(path = "leagues/{leagueId}/teams/{teamId}/players")
    public Team addPlayer(@PathVariable Long leagueId,
                          @PathVariable Long teamId,
                          @RequestBody Player player){
        return teamsService.addPlayer(leagueId, teamId, player);
    }


    @GetMapping(path = "teams")
    public Iterable<Team> getAll(){
        return teamsService.getAll();
    }

    @DeleteMapping(path = "teams/{id}")
    public void delete(@PathVariable Long id){
        teamsService.delete(id);
    }
}
