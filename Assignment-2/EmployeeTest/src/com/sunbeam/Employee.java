package com.sunbeam;

import java.util.Scanner;

public class Employee {
	private String FirstName;
	private String LastName;
	private double Salary;
	
	public Employee() {
//		this.FirstName = "null";
//		this.LastName = "null";
//		this.Salary = 0.0;
	}

	public Employee(String firstName, String lastName, double salary) {
		FirstName = firstName;
		LastName = lastName;
		Salary = salary;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		if(Salary > 0) {
			Salary = salary;
		}
	}
	
	public void display() {
		
		System.out.println("Employee FirstName: "+this.FirstName);
		System.out.println("Employee LastName: "+this.LastName);
		if(Salary>0) {
		System.out.println("Employee Salary: "+this.Salary);
		System.out.println("Yearly Salary Before raise: "+(12)*(this.Salary));
		System.out.println("Yearly Salary After raise: "+(12)*((this.Salary)+(this.Salary/10)));
		}else {
			System.out.println("Employee Salary: "+"Invalid Input");
		}
		System.out.println("");
	}
	
	

}
