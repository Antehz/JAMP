package com.epam.module1.core.spring.beans;

public class Client {

	public static int id;
	private String firstName; 
	private String secondName;
	
	static {
		id = 0;
	}
	
	public Client(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		id++;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", secondName=" + secondName + "]";
	}
}
