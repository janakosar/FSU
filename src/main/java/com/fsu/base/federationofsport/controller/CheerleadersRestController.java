package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Advertisement;
import com.fsu.base.federationofsport.model.Cheerleader;
import com.fsu.base.federationofsport.service.IAdvertisementService;
import com.fsu.base.federationofsport.service.ICheerleadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "/api/v1/cheerleaders")
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

    @PostMapping(path = "/create")
    Cheerleader add(@RequestBody Cheerleader cheerleader){

        return cheerleadersService.add(cheerleader);
    }

    @DeleteMapping(path = "/delete/{id}")
    void  delete(@PathVariable Long id){
        cheerleadersService.delete(id);
    }
}

