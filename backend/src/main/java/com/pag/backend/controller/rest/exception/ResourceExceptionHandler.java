package com.pag.backend.controller.rest.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pag.backend.model.ApiErrorListModel;
import com.pag.backend.model.ApiErrorModel;
import com.pag.backend.service.exception.NotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiErrorModel> handleNotFoundException(NotFoundException ex) {
		ApiErrorModel error = new ApiErrorModel(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			errors.add(error.getDefaultMessage());
		});
		
		String defaultMessage = "Invalid field(s)";
		
		ApiErrorListModel error = new ApiErrorListModel(HttpStatus.BAD_REQUEST.value(), defaultMessage, new Date(), errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}