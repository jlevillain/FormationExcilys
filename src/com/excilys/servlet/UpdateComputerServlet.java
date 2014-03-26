package com.excilys.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.DaoFactory;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.ServiceFactory;

/**
 * Servlet implementation class UpdateComputerServlet
 */
@WebServlet("/UpdateComputerServlet")
public class UpdateComputerServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(UpdateComputerServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp");
		long id=Long.parseLong(request.getParameter("id"));
		Computer comp=DaoFactory.getComputerDao().getOne(id);
		
		List<Company> companyList=DaoFactory.getCompanyDao().getAll(); 
		logger.debug(""+companyList);
		request.setAttribute("companyList", companyList);
		request.setAttribute("computer", comp);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			Date introduced=null;
			Date discontinued=null;
			if(request.getParameter("introducedDate").equals("")) {
				introduced=null;
			}else {
				introduced = format.parse(request.getParameter("introducedDate"));
			}
			if(request.getParameter("discontinuedDate").equals("")) {
				discontinued =null;
			}else {
				discontinued = format.parse(request.getParameter("discontinuedDate"));
			}
			logger.debug(""+discontinued+introduced);
			comp.setIntroduced(introduced);
			comp.setDiscontinued(discontinued);
			Company company=new Company();
			if (request.getParameter("company").equals("null")) {
				comp.setCompany(null);
			}else {
				company.setId(Integer.parseInt(request.getParameter("company")));
				comp.setCompany(company);
			}
			
			logger.debug("dzead"+comp.toString());
			ServiceFactory.getComputerService().updateOne(comp);
			response.sendRedirect("");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
