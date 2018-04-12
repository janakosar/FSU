package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Advertisement;

/**
 * Created by yana on 12.04.18.
 */
public interface IAdvertisementService {

    Iterable<Advertisement> getAll();

    Advertisement add(Advertisement advertisement);

    void delete(long id);
}
