package com.qingjie.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qingjie.model.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
