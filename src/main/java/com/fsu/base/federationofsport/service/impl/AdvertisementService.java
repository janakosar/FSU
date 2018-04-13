package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.AdvertisementDao;
import com.fsu.base.federationofsport.model.Advertisement;
import com.fsu.base.federationofsport.service.IAdvertisementService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yana on 12.04.18.
 */
@Service
public class AdvertisementService implements IAdvertisementService {

    private AdvertisementDao advertisementDao;
    private StorageService storageService;

    @Autowired
    public AdvertisementService(AdvertisementDao advertisementDao,
                                StorageService storageService) {
        this.advertisementDao = advertisementDao;
        this.storageService = storageService;
    }

    @Override
    public Iterable<Advertisement> getAll() {
        return advertisementDao.findAll();
    }

    @Override
    public Advertisement add(Advertisement advertisement) {

        advertisement.setImage(storageService.store(advertisement.getImage()));

        return advertisementDao.save(advertisement);
    }

    @Override
    public void delete(long id) {
        advertisementDao.delete(id);
    }
}
