package com.excilys.dto;

import java.util.Date;

import com.excilys.om.Company;

public class CompanyDto {
	private long id=0;
	private String name=null;
	
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
	
	public Company convertToCompany() {
		Company comp=new Company();
		comp.setId(id);
		comp.setName(name);
		return comp;
	}
}
