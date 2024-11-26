package Session25;

//Use of @JsonIgnore annotation to exclude/Ignore fields(Individual Property) of POJO class.

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/*
 
 {
“firstName”: “Dasrath”,
“lastName”: “Singh”,
“gender”: “Male”,
“age”: 33,
“salary”: 21000.50,
"IsMarried": true,
"fullName": "Dasrath Singh"

}
 
 */

@JsonIgnoreProperties(value = {"gender", "age"})

public class EmployeePOJOClass 
{
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean isMarried;
	
	//@JsonIgnore
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String fullName;
	
	
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
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

}
