package com.ayungan.usersapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayungan.usersapp.model.User;
import com.ayungan.usersapp.services.UserService;
import com.ayungan.usersapp.util.QueryResult;
import com.ayungan.usersapp.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.StringUtils;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	// para convertir
	protected ObjectMapper mapper;

	// inserta o actualiza
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) {
		// convierte el string json a una clase
		try {
			this.mapper = new ObjectMapper();
			User user = this.mapper.readValue(userJson, User.class);// convierte json in clase
			if (!this.validate(user)) {
				return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
						"Los compos obligatorios no estan diligenciados" + user.toString());
			}
			this.userService.save(user);
			return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "" + e.getMessage());
		}

	}

	// muestra todos
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> greeting() {
		return this.userService.findAll();
	}

	// eliminar
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public RestResponse deleteUser(@RequestBody String userJson) {
		// convierte el string json a una clase
		try {
			this.mapper = new ObjectMapper();
			User user = this.mapper.readValue(userJson, User.class);// convierte json in clase
			if (user.getId() == null) {
				return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
						"Los compos obligatorios no estan diligenciados" + user.toString());
			}
			this.userService.deleteUser(user);
			return new RestResponse(HttpStatus.OK.value(), "eliminacion exitosa");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "" + e.getMessage());
		}

	}

	// id
	@RequestMapping(value = "/IdUser", method = RequestMethod.POST)
	public QueryResult<User> IdUser(@RequestBody String userJson) {
		// convierte el string json a una clase
		List<User> lst = new ArrayList<>();
		try {
			this.mapper = new ObjectMapper();
			User user = this.mapper.readValue(userJson, User.class);// convierte json in clase
			if (user.getId() == null) {
				return new QueryResult<User>(lst, "Error de Id esta nullo.!", false);
			}
			user = this.userService.UserById(user.getId());
			if (user != null) {
				lst.add(user);
			}

			return new QueryResult<User>(lst, "Correcto.!", true);
		} catch (Exception e) {
			return new QueryResult<User>(lst, "Error ->" + e.getMessage(), false);
		}

	}

	private boolean validate(User user) {
		boolean isvalid = true;
		if (user.getFirst_name() == null) {
			isvalid = false;
			System.out.println(user.getFirst_name());
		}
		if (user.getSecond_name() == null) {
			isvalid = false;
			System.out.println(user.getSecond_name());
		}
		if (user.getUsername() == null) {
			isvalid = false;
			System.out.println(user.getUsername());
		}
		if (user.getPhone() == null) {
			isvalid = false;
			System.out.println(user.getPhone());
		}

		return isvalid;
	}
}
