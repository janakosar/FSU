package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.TrainersDao;
import com.fsu.base.federationofsport.model.Trainer;
import com.fsu.base.federationofsport.service.ITrainersService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yana on 12.04.18.
 */
public class TrainersService implements ITrainersService {

    private TrainersDao trainersDao;

    @Autowired
    TrainersService(TrainersDao trainersDao) {
        this.trainersDao = trainersDao;
    }

    @Override
    public Iterable<Trainer> getAll() {
        return trainersDao.findAll();
    }

    @Override
    public Trainer add(Trainer trainer) {
        return trainersDao.save(trainer);
    }

    @Override
    public void delete(long id) {
        trainersDao.delete(id);
    }
}
