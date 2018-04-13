package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.SponsorsDao;
import com.fsu.base.federationofsport.model.Sponsor;
import com.fsu.base.federationofsport.service.ISponsorsService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yana on 12.04.18.
 */
@Service
public class SponsorsService implements ISponsorsService {

    private SponsorsDao sponsorsDao;
    private StorageService storageService;

    @Autowired
    public SponsorsService(SponsorsDao sponsorsDao,
                           StorageService storageService) {
        this.sponsorsDao = sponsorsDao;
        this.storageService = storageService;
    }

    @Override
    public Iterable<Sponsor> getAll() {
        return sponsorsDao.findAll();
    }

    @Override
    public Sponsor add(Sponsor sponsor) {

        sponsor.setImage(storageService.store(sponsor.getImage()));

        return sponsorsDao.save(sponsor);
    }

    @Override
    public void delete(long id) {
        sponsorsDao.delete(id);
    }
}
