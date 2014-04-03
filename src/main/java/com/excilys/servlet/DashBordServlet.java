package com.excilys.servlet;

import java.io.IOException;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.excilys.dao.ComputerDao;
import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.PageValidator;
import com.excilys.wrapper.Page;

/**
 * Servlet implementation class DashBordServlet
 */

public class DashBordServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(DashBordServlet.class);
	private ApplicationContext context=null;
	private static final long serialVersionUID = 1L;
       
	@Autowired
	ComputerService computerService;
	
	@Autowired
	CompanyService companyService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBordServlet() {
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
		logger.debug("start doGet DashBoard");
		
		List<Computer> computerList=null;
		Integer computerSize;
		
		String search=PageValidator.validSearch(request.getParameter("search"));
		int page=PageValidator.validPage(request.getParameter("page"));
		int orderBy=PageValidator.validOrderBy(request.getParameter("orderBy"));
		boolean desc=PageValidator.validIsDesc(request.getParameter("isDesc"));
		int nbPage = PageValidator.validNbPage(request.getParameter("nbPage"));
		
		computerList=computerService.getAll(search, ((page-1)*nbPage), nbPage,orderBy,desc);
		computerSize=computerService.getSize(search);
		
		Page pageWrapper=Page.build().search(search).page(page).isDesc(desc).
				orderBy(orderBy).nbPage(nbPage).
				computerList(computerList).computerSize(computerSize).build();
		
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp");
		request.setAttribute("page", pageWrapper);

		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
