package com.excilys.om;

import java.util.Date;

public class Computer {
	private long id;
	private String name;
	private Date introduced;
	private Date discontinuted;
	private long company_id;
	
	public Computer() {
		super();
	}
	public Computer(long id, String name, Date introduced, Date discontinuted,
			long company_id) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinuted = discontinuted;
		this.company_id = company_id;
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
	public Date getDiscontinuted() {
		return discontinuted;
	}
	public void setDiscontinuted(Date discontinuted) {
		this.discontinuted = discontinuted;
	}
	public long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinuted=" + discontinuted
				+ ", company_id=" + company_id + "]";
	}
	
	
}
