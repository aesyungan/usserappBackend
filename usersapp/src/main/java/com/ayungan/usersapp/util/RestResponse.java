package com.ayungan.usersapp.util;

import org.apache.logging.log4j.message.Message;

public class RestResponse {

	private Integer responcecode;
	private String message;
	
	public RestResponse(Integer responcecode, String message) {
		super();
		this.responcecode = responcecode;
		this.message = message;
	}
	
	
	public RestResponse() {
		super();
	}

	public Integer getResponcecode() {
		return responcecode;
	}
	public void setResponcecode(Integer responcecode) {
		this.responcecode = responcecode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
