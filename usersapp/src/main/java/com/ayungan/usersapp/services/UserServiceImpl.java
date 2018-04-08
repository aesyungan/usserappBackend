package com.ayungan.usersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.usersapp.dao.UserRepository;
import com.ayungan.usersapp.model.User;

@Controller
public class UserServiceImpl implements UserService {
	@Autowired
	protected UserRepository userRepository;

	public User save(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public void deleteUser(User user)   {
		// TODO Auto-generated method stub
		try {
			 this.userRepository.deleteById(user.getId());
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	@Override
	public User UserById(Long id) {
		// TODO Auto-generated method stub
		try {
			return  this.userRepository.UserById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
