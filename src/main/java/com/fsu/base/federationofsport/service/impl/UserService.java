package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.UserDao;
import com.fsu.base.federationofsport.model.User;
import com.fsu.base.federationofsport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yana on 04.04.18.
 */

@Service(value = "userService")
public class UserService implements UserDetailsService, IUserService {

    private UserDao userDao;

    @Autowired
    UserService(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDao.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findById(long id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
