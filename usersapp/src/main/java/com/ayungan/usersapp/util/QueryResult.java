package com.ayungan.usersapp.util;

import java.util.List;

public class QueryResult<T> {

	private int totalRecords;
	private List<T> list;
	private String message;
	private boolean correct;
	
	

	public QueryResult(List<T> list, String message, boolean correct) {
		super();
		this.list = list;
		this.message = message;
		this.correct = correct;
		this.totalRecords=list.size();
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	
}
