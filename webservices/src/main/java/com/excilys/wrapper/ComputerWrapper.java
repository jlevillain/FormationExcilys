package com.excilys.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

import com.excilys.om.Computer;

@XmlRootElement(name="computers")
public class ComputerWrapper {
	List<Computer> items;
	@XmlElement(name="computer")
	public List<Computer> getItems() {
		return items;
	}

	public void setItems(List<Computer> items) {
		this.items = items;
	}
}
