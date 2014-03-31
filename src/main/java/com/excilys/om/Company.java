package com.excilys.om;

import com.excilys.dto.CompanyDto;

public class Company {
	private long id;
	private String name;
	
	public Company() {
		super();
	}
	public Company(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Company))
			return false;
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public CompanyDto convertToDto() {
		CompanyDto compDto=new CompanyDto();
		compDto.setId(id);
		compDto.setName(name);
		return compDto;
		
	}
}
