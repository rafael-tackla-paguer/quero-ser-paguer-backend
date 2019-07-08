package com.pag.backend.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6487416829433404888L;
	
	private int code;
	private String msg;
	private Date date;
}
