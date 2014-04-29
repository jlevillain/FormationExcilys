package com.excilys.bean;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.excilys.wrapper.ComputerWrapper;

@WebService
@SOAPBinding(style= Style.RPC)
public interface ComputerService {
	@WebMethod ComputerWrapper getAll();
}
