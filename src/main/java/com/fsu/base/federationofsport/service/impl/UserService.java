package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.UserDao;
import com.fsu.base.federationofsport.model.User;
import com.fsu.base.federationofsport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by yana on 04.04.18.
 */

@Service
public class UserService implements IUserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findOne(username);
    }

    @Override
    public User findByUsername(String id) {
        return userDao.findOne(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public User save(User user){

        String password = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(password));

        User saved = userDao.save(user);
        saved.setPassword(password);

        return saved;
    }
}
