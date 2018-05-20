package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.User;

import java.util.List;

public interface IUserService {

	User save(User user);

	Iterable<User> findAll();

	User findByUsername(String id);

	void delete(String id);
}