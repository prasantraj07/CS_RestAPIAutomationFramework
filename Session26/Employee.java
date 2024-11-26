package Session26;

//Ignore Unknown Properties during Deserialization in below ways:
//1.Using @JsonIgnoreProperties annotation.
//2.Using Object Mapper. 

//Test 1 -> Missing known Property:
//"IsMarried" is there in Employee Class(POJO Class) but not there in Json object.
//Output -> Default value for "IsMarried" which is 'False'.

//Test 2 -> Unknown property added:
//Here "fullName" is there in Json Object of Employee, but variable not created in Employee class(POJO class),
//and is added in 'payload' variable.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 

//JSON Object of Employee:

{
	“firstName”: “Dasrath”,
	“lastName”: “Singh”,
	“gender”: “Male”,
	“age”: 33,
	“salary”: 21000.50,
	"IsMarried": true
	
}

 */

@JsonIgnoreProperties(ignoreUnknown=true)

//POJO class:
public class Employee 

{
		
		private String firstName;
		private String lastName;
		private String gender;
		private int age;
		private double salary;
		private boolean isMarried;
		
		
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
		public boolean getMarried() {
			return isMarried;
		}
		public void setMarried(boolean isMarried) {
			this.isMarried = isMarried;
		}
		
		
}

