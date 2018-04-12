package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.AdvertisementDao;
import com.fsu.base.federationofsport.model.Advertisement;
import com.fsu.base.federationofsport.service.IAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yana on 12.04.18.
 */
public class AdvertisementService implements IAdvertisementService {

    private AdvertisementDao advertisementDao;

    @Autowired
    AdvertisementService(AdvertisementDao advertisementDao) {
        this.advertisementDao = advertisementDao;
    }

    @Override
    public Iterable<Advertisement> getAll() {
        return advertisementDao.findAll();
    }

    @Override
    public Advertisement add(Advertisement advertisement) {
        return advertisementDao.save(advertisement);
    }

    @Override
    public void delete(long id) {
        advertisementDao.delete(id);
    }
}
