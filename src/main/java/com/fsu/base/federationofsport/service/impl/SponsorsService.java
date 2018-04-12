package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.SponsorsDao;
import com.fsu.base.federationofsport.model.Sponsor;
import com.fsu.base.federationofsport.service.ISponsorsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yana on 12.04.18.
 */
public class SponsorsService implements ISponsorsService {

    private SponsorsDao sponsorsDao;

    @Autowired
    SponsorsService(SponsorsDao sponsorsDao) {
        this.sponsorsDao = sponsorsDao;
    }

    @Override
    public Iterable<Sponsor> getAll() {
        return sponsorsDao.findAll();
    }

    @Override
    public Sponsor add(Sponsor sponsor) {
        return sponsorsDao.save(sponsor);
    }

    @Override
    public void delete(long id) {
        sponsorsDao.delete(id);
    }
}
