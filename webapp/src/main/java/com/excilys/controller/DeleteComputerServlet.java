package com.excilys.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.excilys.service.ComputerService;

/**
 * Servlet implementation class DeleteComputer
 */
@Controller
@RequestMapping("/DeleteComputer")
public class DeleteComputerServlet {
	Logger logger = LoggerFactory.getLogger(DeleteComputerServlet.class);
	@Autowired
	ComputerService computerService;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
	/**
	 * method doGet of controller
	 * @param id id to delete
	 * @return page
	 */
    @RequestMapping(method=RequestMethod.GET)
	public String doGet( @RequestParam("delete") int id) {
		// TODO Auto-generated method stub
    	logger.debug("deleted "+id);
		computerService.deleteOne(id);
		return "redirect:/";
	}


}
