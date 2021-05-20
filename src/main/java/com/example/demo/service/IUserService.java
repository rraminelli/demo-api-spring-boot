package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface IUserService {

	Optional<User> findByEmail(String email);
	
	User save(User user);
	
	List<User> listAll();
	
}
