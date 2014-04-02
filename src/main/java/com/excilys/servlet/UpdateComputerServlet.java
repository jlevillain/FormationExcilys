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
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;

/**
 * Servlet implementation class UpdateComputerServlet
 */

public class UpdateComputerServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(UpdateComputerServlet.class);
	private static final long serialVersionUID = 1L;
	
	@Autowired
	CompanyService companyService;
	@Autowired
	ComputerService computerService;
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
			long id=Long.parseLong(request.getParameter("id"));
		
			Computer comp=computerService.getOne(id);
			
			List<Company> companyList=companyService.getAll(); 
			logger.debug(""+companyList);
			request.setAttribute("companyList", companyList);
			request.setAttribute("computer", comp);
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
		if (request.getParameter("id")!=null && request.getParameter("name")!=null 
				&& ! request.getParameter("name").equals("") &&request.getParameter("introducedDate")!=null
				&& request.getParameter("discontinuedDate")!=null && request.getParameter("company")!=null) {
			try {
				Computer comp=new Computer();
				comp.setId(Long.parseLong(request.getParameter("id")));
				comp.setName(request.getParameter("name"));
				/*
				SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-DD");
				Date introduced = format.parse(request.getParameter("introducedDate"));
				Date discontinued = format.parse(request.getParameter("discontinuedDate"));
				comp.setIntroduced(introduced);
				comp.setDiscontinued(discontinued);
				*/
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				format.setLenient(false);
				Date introduced=null;
				Date discontinued=null;
				if("".equals(request.getParameter("introducedDate"))) {
					introduced=null;
				}else {
					introduced = format.parse(request.getParameter("introducedDate"));
				}
				if("".equals(request.getParameter("discontinuedDate"))) {
					discontinued =null;
				}else {
					discontinued = format.parse(request.getParameter("discontinuedDate"));
				}
				logger.debug(""+discontinued+introduced);
				comp.setIntroduced(introduced);
				comp.setDiscontinued(discontinued);
				Company company=new Company();
				if ("null".equals(request.getParameter("company"))) {
					comp.setCompany(null);
				}else {
					company.setId(Integer.parseInt(request.getParameter("company")));
					comp.setCompany(company);
				}
				
				logger.debug("Computer "+comp.toString());
				computerService.updateOne(comp);
				response.sendRedirect("");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				logger.debug("NumberFormatException "+e.getStackTrace());
			}catch (ParseException e) {
				logger.debug("ParseException "+e.getStackTrace());
			}
		}
	}

}
