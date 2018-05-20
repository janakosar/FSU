package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.LiguesDao;
import com.fsu.base.federationofsport.model.Ligue;
import com.fsu.base.federationofsport.service.ILiguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiguesService implements ILiguesService {

    private LiguesDao liguesDao;

    @Autowired
    public LiguesService(LiguesDao liguesDao) {
        this.liguesDao = liguesDao;
    }

    @Override
    public Ligue create(Ligue ligue) {
        return liguesDao.save(ligue);
    }

    @Override
    public Ligue getById(long id) {
        return liguesDao.findOne(id);
    }

    @Override
    public Iterable<Ligue> getAll() {
        return liguesDao.findAll();
    }

    @Override
    public void delete(long id) {
        liguesDao.delete(id);
    }
}
