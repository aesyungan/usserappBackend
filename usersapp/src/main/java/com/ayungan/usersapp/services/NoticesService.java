package com.ayungan.usersapp.services;

import java.util.List;

import com.ayungan.usersapp.model.Notices;
import com.ayungan.usersapp.model.User;

public interface NoticesService {

	Notices save(Notices notices);

	List<Notices> findAll();
}
