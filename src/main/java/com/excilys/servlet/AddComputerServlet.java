package com.excilys.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.ServiceFactory;

/**
 * Servlet implementation class AddComputerServlet
 */
@WebServlet(name = "AddComputer", urlPatterns = { "/AddComputer" })
public class AddComputerServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(AddComputerServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp");
		List<Company> companyList=ServiceFactory.INSTANCE.getCompanyService().getAll();
		logger.debug(""+companyList);
		request.setAttribute("companyList", companyList);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("name")!=null&& !"".equals(request.getParameter("name")) && request.getParameter("introducedDate")!=null
				&& request.getParameter("discontinuedDate")!=null && request.getParameter("company")!=null) {
			try {
				Computer comp=new Computer();
				comp.setName(request.getParameter("name"));
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				format.setLenient(false);
				Date introduced, discontinued;
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
				logger.debug(""+request.getParameter("introducedDate")+request.getParameter("discontinuedDate"));
				logger.debug(""+introduced+discontinued);
				comp.setIntroduced(introduced);
				comp.setDiscontinued(discontinued);
				
				Company company=new Company();
				if ("null".equals(request.getParameter("company"))) {
					comp.setCompany(null);
				}else {
					company.setId(Integer.parseInt(request.getParameter("company")));
					comp.setCompany(company);
				}
				
				logger.debug(comp.toString());
				ServiceFactory.INSTANCE.getComputerService().insertOne(comp);
				response.sendRedirect("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				logger.debug("ParseException "+e.getMessage());
			}catch(NumberFormatException e) {
				logger.debug("NumberFormatException"+e.getMessage());
			}
		
		}else {
			response.sendRedirect("AddComputer");
		}
		
	}

}