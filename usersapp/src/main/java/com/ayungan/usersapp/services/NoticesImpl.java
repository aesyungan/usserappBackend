package com.ayungan.usersapp.services;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ayungan.usersapp.dao.NoticesRepository;
import com.ayungan.usersapp.dao.UserRepository;
import com.ayungan.usersapp.model.Notices;
import com.ayungan.usersapp.model.User;
@Controller
public class NoticesImpl implements NoticesService {
	@Autowired
	protected NoticesRepository noticesRepository;

	public Notices save(Notices notices) {
		// TODO Auto-generated method stub
		return this.noticesRepository.save(notices);
	}

	@Override
	public List<Notices> findAll() {
		return this.noticesRepository.findAll();
	}
}