package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Cheerleader;
import com.fsu.base.federationofsport.service.ICheerleadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "/api/cheerleaders")
public class CheerleadersRestController {

    private ICheerleadersService cheerleadersService;

    @Autowired
    CheerleadersRestController(ICheerleadersService cheerleadersService) {
        this.cheerleadersService = cheerleadersService;
    }

    @GetMapping
    Iterable<Cheerleader> getAll() {
        return cheerleadersService.getAll();
    }

    @PostMapping
    Cheerleader add(@RequestBody Cheerleader cheerleader){

        return cheerleadersService.add(cheerleader);
    }

    @DeleteMapping
    void  delete(@PathVariable Long id){
        cheerleadersService.delete(id);
    }
}

