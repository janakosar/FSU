package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Ligue;
import com.fsu.base.federationofsport.service.ILiguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/ligues")
public class LiguesRestController {

    private ILiguesService liguesService;

    @Autowired
    public LiguesRestController(ILiguesService liguesService) {
        this.liguesService = liguesService;
    }

    @PostMapping
    public Ligue create(@RequestBody Ligue ligue) {
        return liguesService.create(ligue);
    }

    @GetMapping(path = "/{id}")
    public Ligue getById(@PathVariable Long id){
        return liguesService.getById(id);
    }

    @GetMapping
    public Iterable<Ligue> getAll(){
        return liguesService.getAll();
    }

    @DeleteMapping(path = "/id")
    public void delete(@PathVariable Long id){
        liguesService.delete(id);
    }
}
