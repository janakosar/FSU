package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.CheerleadersDao;
import com.fsu.base.federationofsport.model.Cheerleader;
import com.fsu.base.federationofsport.service.ICheerleadersService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yana on 12.04.18.
 */
@Service
public class CheerleadersService implements ICheerleadersService {

    private CheerleadersDao cheerleadersDao;
    private StorageService storageService;

    @Autowired
    public CheerleadersService(CheerleadersDao cheerleadersDao,
                               StorageService storageService) {
        this.cheerleadersDao = cheerleadersDao;
        this.storageService  = storageService;
    }

    @Override
    public Iterable<Cheerleader> getAll() {
        return cheerleadersDao.findAll();
    }

    @Override
    public Cheerleader add(Cheerleader cheerleader) {

        cheerleader.setImage(storageService.store(cheerleader.getImage()));

        return cheerleadersDao.save(cheerleader);
    }

    @Override
    public void delete(long id) {
        cheerleadersDao.delete(id);
    }
}
