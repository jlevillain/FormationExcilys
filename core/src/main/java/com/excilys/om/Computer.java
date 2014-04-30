package com.excilys.om;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Class containing the computer in the database
 * 
 * @author jlevillain
 *
 */

@Entity
@Table(name="computer")
@XmlRootElement(name="computer")
public class Computer {
	@Id 
	@Column(name="id",unique=true,nullable=false) 
	@GeneratedValue
	private long id;
	@Column(name="name",nullable=false)
	private String name="";
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="introduced")
	private DateTime introduced=null;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="discontinued")
	private DateTime discontinued=null;
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="company_id")
	private Company company=new Company();
	
	/**
	 * Default constructor of computer
	 */
	public Computer() {
		super();
	}
	
	/**
	 * Constructor of Computer
	 * 
	 * @param id id of computer
	 * @param name name of computer
	 * @param introduced introduced date of computer
	 * @param discontinued discontinued date of computer
	 * @param company company of computer
	 */
	public Computer(long id, String name, DateTime introduced, DateTime discontinued,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
	}
	
	/**
	 * get the id of computer
	 * 
	 * @return id of computer
	 */
	@XmlElement
	public long getId() {
		return id;
	}
	
	/**
	 * set the id of computer
	 * 
	 * @param id id of computer
	 * 
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * get the name of computer
	 * 
	 * @return name of computer
	 */
	@XmlElement
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
	 * get the introduced date of computer
	 * 
	 * @return introduced date of computer
	 */
	@XmlElement
	
	public DateTime getIntroduced() {
		return introduced;
	}
	
	/**
	 * set the introduced date of computer
	 * 
	 * @param introduced introduced date of computer
	 */
	public void setIntroduced(DateTime introduced) {
		this.introduced = introduced;
	}
	
	/**
	 * get the discontinued date of computer
	 * 
	 * @return discontinued date of computer
	 */
	@XmlElement
	public DateTime getDiscontinued() {
		return discontinued;
	}
	
	/**
	 * set the discontinued date of computer
	 * 
	 * @param discontinued discontinued date of computer
	 */
	public void setDiscontinued(DateTime discontinued) {
		this.discontinued = discontinued;
	}
	
	/**
	 * get the company of computer
	 * 
	 * @return company of computer
	 */
	@XmlElement
	public Company getCompany() {
		return company;
	}
	
	/**
	 * set the company of computer
	 * 
	 * @param company company of computer
	 */
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
	
	/**
	 * builder of computer
	 * 
	 * @author jlevillain
	 *
	 */
	public static class Builder {
		Computer computer;
		/**
		 * constructor of builder 
		 */
		private Builder()  {
			computer=new Computer();
		}
		
		/**
		 * set the name of computer
		 * @param name name of computer
		 * @return builder of computer
		 */
		public Builder name(String name) {
			this.computer.setName(name);
			return this;
		}
		
		/**
		 * set the if of computer
		 * @param id id of computer
		 * @return builder of computer
		 */
		public Builder id(long id) {
			this.computer.setId(id);
			return this;
		}
		/**
		 * set introduced date of computer
		 * @param introduced introduced date of computer
		 * @return builder of computer
		 */
		public Builder introduced(DateTime introduced) {
			this.computer.setIntroduced(introduced);
			return this;
		}
		/**
		 * set the discontinued date of computer
		 * @param discontinued discontinued date of computer
		 * @return builder of computer
		 */
		public Builder discontinued(DateTime discontinued) {
			this.computer.setDiscontinued(discontinued);
			return this;
		}
		/**
		 * set the company of computer
		 * @param company company of computer
		 * @return builder of computer
		 */
		public Builder company(Company company)  {
			this.computer.setCompany(company);
			return this;
		}
		/**
		 * construct the computer object
		 * @return computer object
		 */
		public Computer build()  {
			return this.computer;
		}
	}
	
	/**
	 * get the builder of computer
	 * @return builder of computer
	 */
	public static Builder build() {
		return new Builder();
	}
}
