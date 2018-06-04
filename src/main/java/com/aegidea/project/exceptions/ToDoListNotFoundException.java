package com.aegidea.project.exceptions;

/**
 * 
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */

public class ToDoListNotFoundException extends RuntimeException {

  public ToDoListNotFoundException(String exception) {
    super(exception);
  }

}