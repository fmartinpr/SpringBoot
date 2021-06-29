package com.fmartin.core.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable{
	private static final long serialVersionUID = -9094915255358212804L;
	private String message;

	public ErrorDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
