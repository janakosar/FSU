package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.TrainersDao;
import com.fsu.base.federationofsport.model.Trainer;
import com.fsu.base.federationofsport.service.ITrainersService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yana on 12.04.18.
 */
@Service
public class TrainersService implements ITrainersService {

    private TrainersDao trainersDao;
    private StorageService storageService;

    @Autowired
    public TrainersService(TrainersDao trainersDao,
                           StorageService storageService) {
        this.trainersDao = trainersDao;
        this.storageService = storageService;
    }

    @Override
    public Iterable<Trainer> getAll() {
        return trainersDao.findAll();
    }

    @Override
    public Trainer add(Trainer trainer) {

        trainer.setImage(storageService.store(trainer.getImage()));

        return trainersDao.save(trainer);
    }

    @Override
    public void delete(long id) {
        trainersDao.delete(id);
    }
}
