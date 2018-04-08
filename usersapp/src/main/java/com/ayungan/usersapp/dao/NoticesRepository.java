package com.ayungan.usersapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayungan.usersapp.model.Notices;
import com.ayungan.usersapp.model.User;

public interface NoticesRepository extends JpaRepository<Notices, Long> {
	// update or insert
	@SuppressWarnings("unchecked")
	Notices save(Notices notices);

	@Override
	List<Notices> findAll();
	/*
	 * @Query("select u from users u where u.id = :id") User UsuarioId(@Param("id")
	 * int id);
	 */
}