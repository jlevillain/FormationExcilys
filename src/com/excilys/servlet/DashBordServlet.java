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
		
		List<Computer> computerList=null;
		Integer computerSize;
		
		String search=request.getParameter("search");
		if (search==null) {
			search="";
		}
		computerSize=ServiceFactory.getComputerService().getSize(search);
		int nbPage=1;
		if (request.getParameter("page")!=null && (!request.getParameter("page").equals(""))) {
			nbPage=Integer.parseInt(request.getParameter("page"));
		}
		int orderBy=2;
		if (request.getParameter("orderBy")!=null && (!request.getParameter("orderBy").equals(""))) {
			orderBy=Integer.parseInt(request.getParameter("orderBy"));
		}
		boolean asc=true;
		if (request.getParameter("isDesc")!=null && (request.getParameter("isDesc").equals("true"))) {
			asc=false;
		}else {
			asc=true;
		}
		logger.debug(""+asc);
		computerList=DaoFactory.getComputerDao().getAll(search, ((nbPage-1)*10), 10,orderBy,asc);
		/*
		if(request.getParameter("page")==null && request.getParameter("search")==null) {
			computerList=ServiceFactory.getComputerService().getAll();
		}
		*/
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp");
		
		
		//System.out.println(computerList);
		
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
