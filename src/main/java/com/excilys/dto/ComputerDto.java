package com.excilys.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.excilys.om.Computer;
import com.excilys.utils.DateConverter;

/**
 * Class representing a computer with little object
 * @author jlevillain
 *
 */
public class ComputerDto {
	private String id="";
	
	private String name="";
	private String introduced="";
	private String discontinued="";
	private CompanyDto company=null;
	/**
	 * get the introduced date of computer
	 * 
	 * @return introduced date of computer
	 */
	public String getIntroduced() {
		return introduced;
	}
	/**
	 * set the introduced date of computer
	 * 
	 * @param introduced introduced date of computer
	 */
	public void setIntroduced(String introduced) {
		this.introduced = introduced;
	}
	/**
	 * get the discontinued date of computer
	 * 
	 * @return discontinued date of computer
	 */
	public String getDiscontinued() {
		return discontinued;
	}
	/**
	 * set the discontinued date of computer
	 * 
	 * @param discontinued discontinued date of computer
	 */
	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}
	/**
	 * get the company of computer
	 * 
	 * @return company of computer
	 */
	public CompanyDto getCompany() {
		return company;
	}
	/**
	 * set the company of computer
	 * 
	 * @param company company of computer
	 */
	public void setCompany(CompanyDto companyDto) {
		this.company = companyDto;
	}
	/**
	 * get the id of computer
	 * 
	 * @return id of computer
	 */
	public String getId() {
		return id;
	}
	/**
	 * set the id of computer
	 * 
	 * @param id id of computer
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * get the name of computer
	 * 
	 * @return name of computer
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name of computer
	 * 
	 * @param name name of computer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * builder of computer
	 * 
	 * @author jlevillain
	 *
	 */
	public static class Builder {
		ComputerDto computerDto;
		/**
		 * constructor of builder 
		 */
		private Builder() {
			// TODO Auto-generated constructor stub
			computerDto=new ComputerDto();
		}
		
		/**
		 * set the if of computer
		 * @param id id of computer
		 * @return builder of computer
		 */
		public Builder id(String id)  {
			this.computerDto.setId(id);
			return this;
		}
		/**
		 * set the name of computer
		 * @param name name of computer
		 * @return builder of computer
		 */
		public Builder name(String name) {
			this.computerDto.setName(name);
			return this;
		}
		/**
		 * set introduced date of computer
		 * @param introduced introduced date of computer
		 * @return builder of computer
		 */
		public Builder introduced(String introduced) {
			this.computerDto.setIntroduced(introduced);
			return this;
		}
		/**
		 * set the discontinued date of computer
		 * @param discontinued discontinued date of computer
		 * @return builder of computer
		 */
		public Builder discontinued(String discontinued) {
			this.computerDto.setDiscontinued(discontinued);
			return this;
		}
		/**
		 * set the company of computer
		 * @param company company of computer
		 * @return builder of computer
		 */
		public Builder company(CompanyDto company) {
			this.computerDto.setCompany(company);
			return this;
		}
		/**
		 * construct the computer object
		 * @return computer object
		 */
		public ComputerDto build() {
			return this.computerDto;
		}
		
	}
	/**
	 * get the builder of computer
	 * @return builder of computer
	 */
	public static Builder build() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "ComputerDto [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinued=" + discontinued + ", company="
				+ company + "]";
	}
}
