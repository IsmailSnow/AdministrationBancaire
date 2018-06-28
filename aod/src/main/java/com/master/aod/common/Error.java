package com.master.aod.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class Error {

	private String message;
	private String[] fieldErros;

	public Error(String message, String[] fieldErros) {
		super();
		this.message = message;
		this.fieldErros = fieldErros;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getFieldErros() {
		return fieldErros;
	}

	public void setFieldErros(String[] fieldErros) {
		this.fieldErros = fieldErros;
	}

}
