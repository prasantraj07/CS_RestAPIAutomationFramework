package Session22;

// Create Nested JSON Object using POJO class: 

/*
{
  	“firstName”: “Madhav”,
	“lastName”: “Mehta”,
	“gender”: “Male”,
	“age”: 35,
	“salary”: 10000.50,
	"address":
	{
  		"street":"Park Avenue",
  		"city": "Vijaywada",
  		"state": "Andhra Pradesh",
  		"pin code": 530012
	}
}
*/

public class EmployeePojoClass 
{
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private EmployeeAddress address;
	
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	public EmployeeAddress getAddress() 
	{
		return address;
	}
	public void setAddress(EmployeeAddress address) 
	{
		this.address = address;
	}
	
	
	

}





























