package com.excilys.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.excilys.om.Computer;

public class ComputerDto {
	private long id=0;
	private String name=null;
	private String introduced=null;
	private String discontinued=null;
	private CompanyDto company=null;
	public String getIntroduced() {
		return introduced;
	}
	public void setIntroduced(String introduced) {
		this.introduced = introduced;
	}
	public String getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}
	public CompanyDto getCompany() {
		return company;
	}
	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Computer convertToComputer() throws ParseException {
		Computer comp=null;
		comp=new Computer();
		comp.setId(id);
		comp.setName(name);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		comp.setDiscontinued(format.parse(discontinued));
		comp.setIntroduced(format.parse(introduced));
		comp.setCompany(company.convertToCompany());
		return comp;
	}
}
