package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.PassportsDao;
import com.fsu.base.federationofsport.model.Passport;
import com.fsu.base.federationofsport.service.IPassportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportsService implements IPassportsService {

    private PassportsDao passportsDao;

    @Autowired
    public PassportsService(PassportsDao passportsDao) {
        this.passportsDao = passportsDao;
    }

    @Override
    public Passport create(Passport passport) {
        return passportsDao.save(passport);
    }

    @Override
    public Passport getById(long id) {
        return passportsDao.findOne(id);
    }

    @Override
    public Iterable<Passport> getAll() {
        return passportsDao.findAll();
    }

    @Override
    public void delete(long id) {
        passportsDao.delete(id);
    }
}
