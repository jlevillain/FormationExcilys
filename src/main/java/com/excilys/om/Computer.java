package com.excilys.om;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.excilys.dto.ComputerDto;

public class Computer {
	private long id;
	private String name=null;
	private Date introduced=null;
	private Date discontinued=null;
	private Company company=null;
	
	public Computer() {
		super();
	}
	public Computer(long id, String name, Date introduced, Date discontinued,
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
	public Date getIntroduced() {
		return introduced;
	}
	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}
	public Date getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Date discontinued) {
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
		if (id==other.id)
			return false;
		return true;
	}
	
	public ComputerDto convertToDto() {
		ComputerDto compDto=new ComputerDto();
		compDto.setId(id);
		compDto.setName(name);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		if (introduced != null) {
			compDto.setIntroduced(format.format(introduced));
		}
		if (introduced != null) {
			compDto.setDiscontinued(format.format(discontinued));
		}
		compDto.setCompany(company.convertToDto());
		return compDto;
		
	}
	
}
