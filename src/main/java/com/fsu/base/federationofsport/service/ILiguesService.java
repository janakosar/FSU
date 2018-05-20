package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Ligue;

public interface ILiguesService {

    Ligue create(Ligue ligue);

    Ligue getById(long id);

    Iterable<Ligue> getAll();

    void delete(long id);

}
