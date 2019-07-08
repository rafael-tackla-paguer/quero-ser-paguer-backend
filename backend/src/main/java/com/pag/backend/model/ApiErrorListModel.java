package com.pag.backend.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiErrorListModel extends ApiErrorModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 481569022317705461L;
	private List<String> errors;
	
	public ApiErrorListModel(int code, String msg, Date date, List<String> errors) {
		super(code, msg, date);
		this.errors = errors;
	}
	
}
