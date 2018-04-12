package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Sponsor;
import com.fsu.base.federationofsport.service.ISponsorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "/api/v1/sponsors")
public class SponsorsRestController {

    private ISponsorsService sponsorsService;

    @Autowired
    SponsorsRestController(ISponsorsService sponsorsService) {
        this.sponsorsService = sponsorsService;
    }

    @GetMapping
    Iterable<Sponsor> getAll() {
        return sponsorsService.getAll();
    }

    @PostMapping
    Sponsor add(@RequestBody Sponsor sponsor){

        return sponsorsService.add(sponsor);
    }

    @DeleteMapping(path = "/{id}")
    void  delete(@PathVariable Long id){
        sponsorsService.delete(id);
    }
}

