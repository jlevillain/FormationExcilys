package com.excilys.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.excilys.om.Computer;
import com.excilys.utils.DateConverter;

public class ComputerDto {
	private String id="";
	
	private String name="";
	private String introduced="";
	private String discontinued="";
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
	public void setCompany(CompanyDto companyDto) {
		this.company = companyDto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static class Builder {
		ComputerDto computerDto;
		private Builder() {
			// TODO Auto-generated constructor stub
			computerDto=new ComputerDto();
		}
		
		public Builder id(String id)  {
			this.computerDto.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			this.computerDto.setName(name);
			return this;
		}
		
		public Builder introduced(String introduced) {
			this.computerDto.setIntroduced(introduced);
			return this;
		}
		
		public Builder discontinued(String discontinued) {
			this.computerDto.setDiscontinued(discontinued);
			return this;
		}
		
		public Builder company(CompanyDto company) {
			this.computerDto.setCompany(company);
			return this;
		}
		
		public ComputerDto build() {
			return this.computerDto;
		}
		
	}
	
	public static Builder build() {
		return new Builder();
	}

	/*
	public Computer convertToComputer() throws ParseException {
		Computer comp=null;
		comp=new Computer();
		
		comp.setName(name);
		comp.setDiscontinued(DateConverter.convertStringToDateTime(discontinued));
		comp.setIntroduced(DateConverter.convertStringToDateTime(introduced));
		
		return comp;
	}
	*/
	@Override
	public String toString() {
		return "ComputerDto [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinued=" + discontinued + ", company="
				+ company + "]";
	}
}
