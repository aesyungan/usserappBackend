package com.ayungan.usersapp.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ayungan.usersapp.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	
	User UserById(Long id);

	void deleteUser(User user);
}
