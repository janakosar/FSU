package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Passport;

public interface IPassportsService {

    Passport create(Passport passport);

    Passport getById(long id);

    Iterable<Passport> getAll();

    void delete(long id);

}
