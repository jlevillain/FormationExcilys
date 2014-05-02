package com.excilys.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.bean.ComputerService;
import com.excilys.wrapper.ComputerWrapper;

@RestController
@RequestMapping("/computer")
public class JSONController {
	
	@Autowired
	ComputerService computerService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody ComputerWrapper getAll() {
		return computerService.getAll();
	}
}
