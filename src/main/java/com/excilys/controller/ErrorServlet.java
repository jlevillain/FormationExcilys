package com.excilys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.excilys.exception.SQLRuntimeException;

@ControllerAdvice
public class ErrorServlet {
	@ExceptionHandler(SQLRuntimeException.class)
	public ModelAndView handleSqlRuntimeException(SQLRuntimeException ex) {
		ModelAndView model=new ModelAndView("error/errorSql");
		model.addObject("exception", ex);
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(SQLRuntimeException ex) {
		ModelAndView model=new ModelAndView("error/errorSql");
		model.addObject("exception", ex);
		return model;
	}
}
