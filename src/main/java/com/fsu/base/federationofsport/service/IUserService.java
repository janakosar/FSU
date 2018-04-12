package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.User;

import java.util.List;

public interface IUserService {

	User save(User user);

	List<User> findAll();

	User findById(long id);

	void delete(long id);
}