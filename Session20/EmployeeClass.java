package Session20;


// Serialization -> convert employee class object to JSON object.
// Deserialization -> reverse of serialization.
// Creating Getters&Setters: Right Click on line of creation->Source->Generate getters & setters.
//	Below is a POJO class representing Employee entity.


/*
 * {
  	“firstName”: “Madhav”,
	“lastName”: “Mehta”,
	“gender”: “Male”,
	“age”: 35,
	“salary”: 10000.50
	}
 * 
 */
public class EmployeeClass 
{
	
	//create private variables of employee:
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	
	
	//gettter and setter methods:
	
	
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

	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;	
	}

}
