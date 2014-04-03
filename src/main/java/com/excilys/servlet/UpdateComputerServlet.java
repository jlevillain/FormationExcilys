package com.excilys.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.excilys.dao.DaoFactory;
import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.ComputerValidator;

/**
 * Servlet implementation class UpdateComputerServlet
 */

public class UpdateComputerServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(UpdateComputerServlet.class);
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ComputerService computerService;
	@Autowired
	private ComputerMapper computerMapper;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			RequestDispatcher disp=getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp");
			if (request.getAttribute("computer")==null) {
				long id=Long.parseLong(request.getParameter("id"));
				Computer comp=computerService.getOne(id);	
				request.setAttribute("computer", comp);
			}
			List<Company> companyList=companyService.getAll(); 
			request.setAttribute("companyList", companyList);
			disp.forward(request, response);
		}catch (NumberFormatException e) {
			logger.debug("id not long");
			response.sendRedirect("");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean succeed=false;
		CompanyDto compDto=CompanyDto.build().
				id(request.getParameter("company")).
				name("a").build();
		ComputerDto cdto=ComputerDto.build().
			id(request.getParameter("id")).
			name(request.getParameter("name")).
			introduced(request.getParameter("introducedDate")).
			discontinued(request.getParameter("discontinuedDate")).
			company(compDto).build();
		/*
		if (request.getParameter("id")!=null && request.getParameter("name")!=null 
				&& ! request.getParameter("name").equals("") &&request.getParameter("introducedDate")!=null
				&& request.getParameter("discontinuedDate")!=null && request.getParameter("company")!=null) {
			*/
		request.setAttribute("computer", cdto);
		List<String> error=ComputerValidator.valide(cdto);
		request.setAttribute("error", error);
		if ( error.size()==0 ) {
			Computer comp=computerMapper.convertDtoToComputer(cdto);
			if (comp!=null) {
				logger.debug(comp.toString());
				computerService.updateOne(comp);
				succeed=true;
				response.sendRedirect("");
			}
		}
		if (!succeed) {
			this.doGet(request, response);
		}
	}

}
