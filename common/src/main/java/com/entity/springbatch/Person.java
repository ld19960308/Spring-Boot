package com.entity.springbatch;
//@Entity
public class Person {
	//@Id
	private Integer personId;
	//@Column(name="first_name")
	private String firstName;
	//@Column(name="last_name")
	private String lastName;
	
	public Person(){}
	
	public Person(String first_name, String last_name) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPerson_id(Integer person_id) {
		this.personId = person_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

}
