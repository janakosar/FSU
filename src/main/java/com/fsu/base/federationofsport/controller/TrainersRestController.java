package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Trainer;
import com.fsu.base.federationofsport.service.ITrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "/api/trainers")
public class TrainersRestController {

    private ITrainersService trainersService;

    @Autowired
    TrainersRestController(ITrainersService trainersService) {
        this.trainersService = trainersService;
    }

    @GetMapping
    Iterable<Trainer> getAll() {
        return trainersService.getAll();
    }

    @PostMapping
    Trainer add(@RequestBody Trainer trainer){

        return trainersService.add(trainer);
    }

    @DeleteMapping(path = "/{id}")
    void  delete(@PathVariable Long id){
        trainersService.delete(id);
    }

}
