package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Trainer;

/**
 * Created by yana on 12.04.18.
 */
public interface ITrainersService {

    Iterable<Trainer> getAll();

    Trainer add(Trainer trainer);

    void delete(long id);
}
