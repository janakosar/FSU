package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

	User save(User user);

	Iterable<User> findAll();

	User findByUsername(String id);

	void delete(String id);
}