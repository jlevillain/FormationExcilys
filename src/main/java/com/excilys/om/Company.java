package com.excilys.om;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.excilys.om.Computer.Builder;

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
	
	public static class Builder {
		Company company;
		private Builder() {
			company=new Company();
		}
		
		public Builder id(long id) {
			this.company.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			this.company.setName(name);
			return this;
		}
		
		public Company build() {
			return company;
		}
	}
	
	public static Builder build() {
		return new Builder();
	}
}
