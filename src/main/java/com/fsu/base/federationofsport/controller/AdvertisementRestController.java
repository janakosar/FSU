package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Advertisement;
import com.fsu.base.federationofsport.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yana on 12.04.18.
 */
@RestController
@RequestMapping(value = "api/v1/advertisement")
public class AdvertisementRestController {

    private IAdvertisementService advertisementService;

    @Autowired
    AdvertisementRestController(IAdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping
    Iterable<Advertisement> getAll() {
        return advertisementService.getAll();
    }

    @PostMapping
    Advertisement add(@RequestBody Advertisement advertisement){

        return advertisementService.add(advertisement);
    }

    @DeleteMapping(path = "/{id}")
    void  delete(@PathVariable Long id){
        advertisementService.delete(id);
    }
}
