package ch.ricardo.project.controller;

import ch.ricardo.project.exceptions.ToDoListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@RestControllerAdvice
public class WebRestControllerAdvice {
	
	@ExceptionHandler(ToDoListNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(ToDoListNotFoundException ex) {
		String responseMsg = ex.getMessage();
		return responseMsg;
	}
  
}
