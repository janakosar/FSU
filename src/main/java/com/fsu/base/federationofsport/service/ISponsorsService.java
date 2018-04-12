package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Sponsor;

/**
 * Created by yana on 12.04.18.
 */
public interface ISponsorsService {

    Iterable<Sponsor> getAll();

    Sponsor add(Sponsor sponsor);

    void delete(long id);

}
