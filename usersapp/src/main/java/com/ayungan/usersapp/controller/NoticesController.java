package com.ayungan.usersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayungan.usersapp.model.Notices;
import com.ayungan.usersapp.model.User;
import com.ayungan.usersapp.services.NoticesService;
import com.ayungan.usersapp.services.UserService;
import com.ayungan.usersapp.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class NoticesController {

	@Autowired
	protected NoticesService noticesService;
	// para convertir
	protected ObjectMapper mapper;
	@RequestMapping(value = "/notices", method = RequestMethod.GET)
	public List<Notices> greeting() {
		return this.noticesService.findAll();
	}
	
	@RequestMapping(value = "/notices/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String json) {
		// convierte el string json a una clase
		try {
			this.mapper = new ObjectMapper();
			Notices item = this.mapper.readValue(json, Notices.class);// convierte json in clase
			if (!this.validate(item)) {
				return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
						"Los compos obligatorios no estan diligenciados" + item.toString());
			}
			this.noticesService.save(item);
			return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "" + e.getMessage());
		}

	}
	private boolean validate(Notices item) {
		boolean isvalid = true;
		if (item.getDescription() == null) {
			isvalid = false;
		
		}
		if (item.getUser().getId() == null) {
			isvalid = false;
		
		}		
		return isvalid;
	}

}
