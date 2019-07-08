package com.pag.backend.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4553341160263954035L;
    
    private static final String DEFAULT_MESSAGE = "Nenhum registro encontrado.";
    
    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }   
   
}
