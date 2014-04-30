package com.excilys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.excilys.bean.ComputerService;
import com.excilys.wrapper.ComputerWrapper;

@Controller
@RequestMapping("/computer")
public class JSONController {
	
	@Autowired
	ComputerService computerService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public @ResponseBody ComputerWrapper getAll() {
		return computerService.getAll();
	}
}
