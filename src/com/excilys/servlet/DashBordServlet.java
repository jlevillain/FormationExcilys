package com.excilys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.ComputerDao;
import com.excilys.dao.DaoFactory;
import com.excilys.om.Computer;
import com.excilys.service.ComputerService;
import com.excilys.service.ServiceFactory;

/**
 * Servlet implementation class DashBordServlet
 */
@WebServlet("/DashBordServlet")
public class DashBordServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(DashBordServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("delete")!=null) {
			DaoFactory.getComputerDao().deleteOne(Long.parseLong(request.getParameter("delete")));
		}
		List<Computer> computerList=null;
		if (request.getParameter("search")!=null) {
			computerList=ServiceFactory.getComputerService().getSearch(request.getParameter("search"));
		}else{
			computerList=ServiceFactory.getComputerService().getAll();
		}
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp");
		
		
		//System.out.println(computerList);
		Integer computerSize=ServiceFactory.getComputerService().getSize();
		System.out.println(computerSize);
		request.setAttribute("computerList",computerList);
		request.setAttribute("computerSize", computerSize);
		logger.debug("coucou");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
