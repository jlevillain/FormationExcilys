package com.excilys.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excilys.bean.ComputerService;
import com.excilys.wrapper.ComputerWrapper;

@WebService
@Component(value = "computerWS")
public class ComputerServiceWS {

	@Autowired
	ComputerService computerService;

	@WebMethod(operationName = "getAll")
	public ComputerWrapper getAll() {
		return computerService.getAll();
	}

}
