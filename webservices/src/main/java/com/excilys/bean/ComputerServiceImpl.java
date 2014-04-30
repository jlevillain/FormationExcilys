package com.excilys.bean;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excilys.wrapper.ComputerWrapper;


@Component(value="computerS")
public class ComputerServiceImpl implements ComputerService {
	
	@Autowired
	com.excilys.service.ComputerService service;
	
	@Override
	public ComputerWrapper getAll() {
		// TODO Auto-generated method stub
		ComputerWrapper compWrapper=new ComputerWrapper();
		compWrapper.setItems(service.getAll());
		return compWrapper;
	}

}
