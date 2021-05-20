package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	@Transactional(readOnly = true)
	Optional<User> findByEmail(String email);
	
}
