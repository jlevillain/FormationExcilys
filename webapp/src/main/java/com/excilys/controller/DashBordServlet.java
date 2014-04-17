package com.excilys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;
import com.excilys.validator.PageValidator;
import com.excilys.wrapper.Page;

/**
 * Servlet implementation class DashBordServlet
 */
@Controller
@RequestMapping("/DashBoard")
public class DashBordServlet {
	Logger logger = LoggerFactory.getLogger(DashBordServlet.class);
	private ApplicationContext context=null;
	private static final long serialVersionUID = 1L;
       
	@Autowired
	ComputerMapper computerMapper;
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
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    /**
     * method doGet of dashboard controller
     * @param searchParam search parameter
     * @param pageParam actual page parameter
     * @param orderByParam orderBy parameter
     * @param isDescParam isDesc parameter
     * @param nbPageParam nbPage parameter
     * @param lang lang parameter
     * @param langCookie cookie
     * @param model model
     * @return name of page 
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(method=RequestMethod.GET)
	public String doGet(@RequestParam(value="search",required=false) String searchParam,
			@RequestParam(value="page",required=false) String pageParam, 
			@RequestParam(value="orderBy",required=false) String orderByParam,
			@RequestParam(value="isDesc",required=false) String isDescParam,
			@RequestParam(value="nbPage",required=false) String nbPageParam,
			@RequestParam(value="lang",required=false) String lang, 
			@CookieValue(value="org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",defaultValue="en",required=false) String langCookie
			, ModelMap model) throws IOException {
		// TODO Auto-generated method stub
		logger.debug("start doGet DashBoard "+lang+" "+langCookie);
		if (lang==null) {
			lang=langCookie;
		}
		/*
		Cookie[] cook=request.getCookies();
		for(Cookie c:cook) {
			System.out.println(c.getName()+" "+c.getValue());
		}
		*/
		List<Computer> computerList=null;
		Integer computerSize;
		
		String search=PageValidator.validSearch(searchParam);
		int page=PageValidator.validPage(pageParam);
		int orderBy=PageValidator.validOrderBy(orderByParam);
		boolean desc=PageValidator.validIsDesc(isDescParam);
		int nbPage = PageValidator.validNbPage(nbPageParam);
		
		computerList=computerService.getAll(search, ((page-1)*nbPage), nbPage,orderBy,desc);
		computerSize=computerService.getSize(search);
		List<ComputerDto> computerDtoList=new ArrayList<ComputerDto>();
		for(Computer comp : computerList) {
			computerDtoList.add(computerMapper.convertComputerToDto(comp));
		}
		
		Page pageWrapper=Page.build().search(search).page(page).isDesc(desc).
				orderBy(orderBy).nbPage(nbPage).
				computerList(computerDtoList).computerSize(computerSize).build();
		
		
		model.addAttribute("page", pageWrapper);

		return "dashboard";
	}

}
