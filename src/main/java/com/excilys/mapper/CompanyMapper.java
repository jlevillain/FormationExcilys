package com.excilys.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.om.Company;
import com.excilys.om.Computer;
import com.excilys.service.CompanyService;

@Component
public class CompanyMapper {
	@Autowired
	private CompanyService companyService;
	
	public Company convertDtoToCompany(CompanyDto companyDto) {
		long id=Long.parseLong(companyDto.getId());
		if (id==0)
			return null;
		Company company = Company.build().id(id).name(companyDto.getName()).build();
		return company;
	}
	
	public CompanyDto convertCompanyToDto(Company company) {
		if (company==null)
			return null;
		CompanyDto comp=CompanyDto.build().id(""+company.getId()).
				name(company.getName()).build();
		return comp;
	}
}
