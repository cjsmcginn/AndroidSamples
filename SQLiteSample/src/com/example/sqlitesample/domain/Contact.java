package com.example.sqlitesample.domain;

public class Contact {
	private String firstName;
	private String lastName;
	private String middleInitial;
	private Long id;
	public Contact(){}
	public Contact(Long id,String firstName,String lastName, String middleInitial)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	public Long getId() {
		return id;
	}	
	
}
