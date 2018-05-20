package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportsDao  extends CrudRepository<Passport, Long> {
}

