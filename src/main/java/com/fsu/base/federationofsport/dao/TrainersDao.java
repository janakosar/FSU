package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Trainer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yana on 12.04.18.
 */
public interface TrainersDao extends CrudRepository<Trainer, Long>{
}
