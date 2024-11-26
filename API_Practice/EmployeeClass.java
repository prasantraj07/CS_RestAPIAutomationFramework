package API_Practice;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;


public class EmployeeClass 
{

	 	/*
	 	 
		{
			“Name”: “Dasrath Rai”,
			“gender”: “Male”,
			“age”: 33,
			“salary”: 21000.50,
			"IsMarried": true
		}
		
		*/
	
	
	private String Name;
	private String gender;
	private int age;
	private double salary;
	private boolean IsMarried;
	
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isIsMarried() {
		return IsMarried;
	}
	public void setIsMarried(boolean isMarried) {
		IsMarried = isMarried;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}









