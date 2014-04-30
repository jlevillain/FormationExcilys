package com.excilys.om;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class containing the company in the database
 * 
 * @author jlevillain
 *
 */
@Entity
@Table(name="company")
@XmlRootElement(name="company")
public class Company {
	@Id 
	@Column(name="id",nullable=false,unique=true) 
	@GeneratedValue
	private long id=0;
	@Column(name="name",nullable=false)
	private String name="";
	/**
	 * Default constructor of company
	 */
	public Company() {
		super();
	}
	/**
	 * constructor of company
	 * @param id id of company
	 * @param name name of company
	 */
	public Company(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * get the id of company
	 * @return id of company
	 */
	@XmlElement
	public long getId() {
		return id;
	}
	/**
	 * set the company of id
	 * @param id id of company
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * get the name of company
	 * @return name of company
	 */
	@XmlElement
	public String getName() {
		return name;
	}
	/**
	 * set the name of company
	 * @param name name of company
	 */
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
	
	/**
	 * builder of company
	 * @author jlevillain
	 *
	 */
	public static class Builder {
		Company company;
		/**
		 * builder of company
		 */
		private Builder() {
			company=new Company();
		}
		/**
		 * set the id of company
		 * @param id id of company
		 * @return builder of company
		 */
		public Builder id(long id) {
			this.company.setId(id);
			return this;
		}
		/**
		 * set the name of company
		 * @param name name of company
		 * @return builder of company
		 */
		public Builder name(String name) {
			this.company.setName(name);
			return this;
		}
		/**
		 * construct the company object
		 * @return company object
		 */
		public Company build() {
			return company;
		}
	}
	
	/**
	 * get the builder of company
	 * @return builder of company
	 */
	public static Builder build() {
		return new Builder();
	}
}
