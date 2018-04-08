package com.ayungan.usersapp.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ayungan.usersapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// update or insert
	@SuppressWarnings("unchecked")
	User save(User user);

	@Override
	List<User> findAll();

	/*
	 * @Query("select u from users u where u.id = :id") User UsuarioId(@Param("id")
	 * int id);
	 */
	@Query(value = "SELECT * FROM users WHERE id = ?1", nativeQuery = true)
	User UserById(Long id);
}
