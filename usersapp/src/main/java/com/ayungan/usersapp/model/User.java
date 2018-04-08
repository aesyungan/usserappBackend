package com.ayungan.usersapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Column;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	Long id;
	@Column(name = "first_name", nullable = true, length = 255)
	private String first_name;
	@Column(name = "second_name", nullable = true, length = 255)
	private String second_name;
	@Column(name = "username", nullable = true, length = 255)
	private String username;
	@Column(name = "phone", nullable = true, length = 255)
	private String phone;
	@Column(name = "address", nullable = true, length = 255)
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", second_name=" + second_name + ", username="
				+ username + ", phone=" + phone + ", address=" + address + "]";
	}

}
