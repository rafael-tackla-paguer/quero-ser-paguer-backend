package com.pag.backend.model;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe modelo para {@link ResponseEntity} quando houver mais de um erro
 * @author rafael.tackla
 *
 */
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
