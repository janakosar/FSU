package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Cheerleader;

/**
 * Created by yana on 12.04.18.
 */
public interface ICheerleadersService {

    Iterable<Cheerleader> getAll();

    Cheerleader add(Cheerleader cheerleader);

    void delete(long id);
}
