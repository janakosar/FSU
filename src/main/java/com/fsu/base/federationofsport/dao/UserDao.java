package com.fsu.base.federationofsport.dao;

import com.fsu.base.federationofsport.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yana on 04.04.18.
 */
//@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
