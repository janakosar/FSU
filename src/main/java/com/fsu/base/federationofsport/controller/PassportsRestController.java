package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Passport;
import com.fsu.base.federationofsport.service.IPassportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/passports")
public class PassportsRestController {

    private IPassportsService passportsService;

    @Autowired
    public PassportsRestController(IPassportsService passportsService) {
        this.passportsService = passportsService;
    }

    @PostMapping
    public Passport create(@RequestBody Passport passport) {
        return passportsService.create(passport);
    }

    @GetMapping(path = "/{id}")
    public Passport getById(@PathVariable Long id){
        return passportsService.getById(id);
    }

    @GetMapping
    public Iterable<Passport> getAll(){
        return passportsService.getAll();
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody void delete(@PathVariable Long id){
        passportsService.delete(id);
    }
}
