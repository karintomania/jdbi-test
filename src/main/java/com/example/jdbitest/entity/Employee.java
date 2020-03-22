package com.example.jdbitest.entity;

public class Employee{
	int id;
	String firstName;
	String lastName;

	public Employee(int id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(){
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public boolean equals(Object obj) {

        if (obj == this) { 
            return true; 
        } 
  
        if (!(obj instanceof Employee)) { 
            return false; 
        } 
          
        Employee e = (Employee) obj; 
          
        return this.id == e.id
                && this.firstName.equals(e.firstName)
                && this.lastName.equals(e.lastName);

    } 
		
	
}