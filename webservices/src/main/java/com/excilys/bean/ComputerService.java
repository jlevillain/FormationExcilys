package com.excilys.bean;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.excilys.wrapper.ComputerWrapper;

public interface ComputerService {
	ComputerWrapper getAll();
}
