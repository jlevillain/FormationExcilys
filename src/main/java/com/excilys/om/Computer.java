package com.excilys.om;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import com.excilys.dto.ComputerDto;

public class Computer {
	private long id;
	private String name="";
	private DateTime introduced=null;
	private DateTime discontinued=null;
	private Company company=new Company();
	
	public Computer() {
		super();
	}
	public Computer(long id, String name, DateTime introduced, DateTime discontinued,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
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
	public DateTime getIntroduced() {
		return introduced;
	}
	public void setIntroduced(DateTime introduced) {
		this.introduced = introduced;
	}
	public DateTime getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(DateTime discontinued) {
		this.discontinued = discontinued;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinued=" + discontinued
				+ ", company=" + company + "]\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Computer))
			return false;
		Computer other = (Computer) obj;
		if (id!=other.id)
			return false;
		return true;
	}
	
	public ComputerDto convertToDto() {
		ComputerDto compDto=new ComputerDto();
		
		compDto.setName(name);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if (introduced != null) {
			compDto.setIntroduced(format.format(introduced));
		}
		if (introduced != null) {
			compDto.setDiscontinued(format.format(discontinued));
		}
		
		return compDto;
		
	}
	
	public static class Builder {
		Computer computer;
		private Builder()  {
			computer=new Computer();
		}
		
		public Builder name(String name) {
			this.computer.setName(name);
			return this;
		}
		
		public Builder id(long id) {
			this.computer.setId(id);
			return this;
		}
		
		public Builder introduced(DateTime introduced) {
			this.computer.setIntroduced(introduced);
			return this;
		}
		
		public Builder discontinued(DateTime discontinued) {
			this.computer.setDiscontinued(discontinued);
			return this;
		}
		
		public Builder company(Company company)  {
			this.computer.setCompany(company);
			return this;
		}
		
		public Computer build()  {
			return this.computer;
		}
	}
	
	public static Builder build() {
		return new Builder();
	}
}
