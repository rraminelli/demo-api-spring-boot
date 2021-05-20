package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	@Cacheable("userByEmail")
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@CachePut(cacheNames = { "userList", "userByEmail" })
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Cacheable("userList")
	public List<User> listAll() {
		return userRepository.findAll();
	}

}
