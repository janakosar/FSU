package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.CheerleadersDao;
import com.fsu.base.federationofsport.model.Cheerleader;
import com.fsu.base.federationofsport.service.ICheerleadersService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yana on 12.04.18.
 */
public class CheerleadersService implements ICheerleadersService {

    private CheerleadersDao cheerleadersDao;

    @Autowired
    CheerleadersService(CheerleadersDao cheerleadersDao) {
        this.cheerleadersDao = cheerleadersDao;
    }

    @Override
    public Iterable<Cheerleader> getAll() {
        return cheerleadersDao.findAll();
    }

    @Override
    public Cheerleader add(Cheerleader cheerleader) {
        return cheerleadersDao.save(cheerleader);
    }

    @Override
    public void delete(long id) {
        cheerleadersDao.delete(id);
    }
}
