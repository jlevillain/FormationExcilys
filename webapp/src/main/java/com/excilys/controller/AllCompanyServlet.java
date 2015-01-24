package com.excilys.controller;

import com.excilys.dto.CompanyDto;
import com.excilys.mapper.CompanyMapper;
import com.excilys.om.Company;
import com.excilys.service.CompanyService;
import com.excilys.wrapper.CompaniesWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eron on 24/01/15.
 */
@Controller
@RequestMapping("/AllCompany")
public class AllCompanyServlet {

    Logger logger = LoggerFactory.getLogger(AllComputerServlet.class);
    @Autowired
    ApplicationContext context;
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CompaniesWrapper doGet() {
        List<Company> list = null;
        Integer total;
        list = companyService.getAll();
        List<CompanyDto> companyList = new ArrayList<CompanyDto>();
        for (Company comp : list) {
            companyList.add(companyMapper.convertCompanyToDto(comp));
        }
        CompaniesWrapper companiesWrapper = new CompaniesWrapper();
        CompanyDto nullCompany = CompanyDto.build().id("0").name("No company").build();
        companyList.add(0,nullCompany);
        companiesWrapper.setCompanies(companyList);
        companiesWrapper.setTotal(companyList.size());
        return companiesWrapper;
    }

}
