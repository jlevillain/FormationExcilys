package com.excilys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.service.ComputerService;
import com.excilys.service.CompanyService;
import com.excilys.dto.ComputerDto;
import com.excilys.mapper.ComputerMapper;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.validator.PageValidator;
import com.excilys.wrapper.Page;

@RestController
@RequestMapping("/angular/computer")
public class JSONControllerAngular {

	@Autowired
	ComputerService computerService;
	
	@Autowired
	CompanyService companyService;

	@Autowired
	ComputerMapper computerMapper;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Page getAll(@RequestParam(value = "search", required = false) String searchParam,
			@RequestParam(value = "page", required = false) String pageParam,
			@RequestParam(value = "orderBy", required = false) String orderByParam,
			@RequestParam(value = "isDesc", required = false) String isDescParam,
			@RequestParam(value = "nbPage", required = false) String nbPageParam,
			@RequestParam(value = "lang", required = false) String lang,
			@RequestParam(value = "logout", required = false) String logout,
			@CookieValue(value = "org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE", defaultValue = "en", required = false) String langCookie) {
		List<Computer> computerList = null;
		Integer computerSize;

		String search = PageValidator.validSearch(searchParam);
		int page = PageValidator.validPage(pageParam);
		int orderBy = PageValidator.validOrderBy(orderByParam);
		boolean desc = PageValidator.validIsDesc(isDescParam);
		int nbPage = PageValidator.validNbPage(nbPageParam);

		computerList = computerService.getAll(search, page - 1, nbPage, orderBy, desc);
		computerSize = computerService.getSize(search);
		List<ComputerDto> computerDtoList = new ArrayList<ComputerDto>();
		for (Computer comp : computerList) {
			computerDtoList.add(computerMapper.convertComputerToDto(comp));
		}

		Page pageWrapper = Page.build().search(search).page(page).isDesc(desc).orderBy(orderBy).nbPage(nbPage)
				.computerList(computerDtoList).computerSize(computerSize).build();
		return pageWrapper;
	}

	@RequestMapping(value = "/addComputer", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ComputerDto addComputer() {
		return computerMapper.convertComputerToDto(new Computer());
	}
	
	@RequestMapping(value = "/modifyComputer", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ComputerDto modifyComputer(@RequestParam(value="id",required=false) Integer id) {
		if (id==null) {
    		return null;
    	}
		Computer comp=computerService.getOne(id);
		if (comp==null) {
			return null;
		}
		return computerMapper.convertComputerToDto(comp);
	}
	
	@RequestMapping(value = "/companyList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Company> populateComputerList() {
    	List<Company> companyList=companyService.getAll();
		return companyList;
    }

	@RequestMapping(value = "/addComputer", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ComputerDto addCompter(@RequestBody ComputerDto cdto) {
		if (cdto.getName() == null || cdto.getIntroduced() == null || cdto.getDiscontinued() == null
				|| cdto.getCompany() == null) {
			return null;
		}

		// List<String> error=ComputerValidator.valide(cdto);
		// model.addAttribute("error", error);
		// if ( error.size()==0 ) {
		Computer comp = computerMapper.convertDtoToComputer(cdto);
		if (comp != null) {
			computerService.insertOne(comp);
		} else {
			return null;
		}
		// }
		return cdto;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public void doGet( @RequestParam("delete") int id) {
		// TODO Auto-generated method stub
		computerService.deleteOne(id);
	}
}
