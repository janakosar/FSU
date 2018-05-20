package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.Ligue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiguesDao  extends CrudRepository<Ligue, Long> {
}
