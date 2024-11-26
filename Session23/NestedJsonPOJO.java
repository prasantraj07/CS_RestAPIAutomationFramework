package Session23;

import java.util.List;
import Session22.EmployeePojoClass;

/*

{
"companyName": "XYZ Ltd.",
"Street": "Dalal Street"
		  "City": "Mumbai",
		  "State": "Maharashtra",
		  "pin code": "220013"
"BankAccounts":["HDFC", "SBI", "AXIS"]

"employee":
[
{
  	“firstName”: “Madhav”,
	“lastName”: “Ambedkar”,
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
},
{
  	“firstName”: “Radhika”,
	“lastName”: “Dubey”,
	“gender”: “Female”,
	“age”: 34,
	“salary”: 25000.50,
	"address":
	{
  		"street":"Park Street",
  		"city": "Kolkata",
  		"state": "West Bengal",
  		"pin code": 711109
	}
},
{
  	“firstName”: “Sitara”,
	“lastName”: “Singh”,
	“gender”: “Male”,
	“age”: 33,
	“salary”: 21000.50,
	"address":
	{
  		"street":"Richmond Road",
  		"city": "Bengaluru",
  		"state": "Karnataka",
  		"pin code": 560069
	}
}
]
}
 
 */


public class NestedJsonPOJO 
{
	private String companyName;
	private String street;
	private String city;
	private String state;
	private String pinCode;
	private List<String> bankAccount;
	
	private List<EmployeePojoClass> employeelist;
	
	//getters & setters:
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public List<String> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<EmployeePojoClass> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<EmployeePojoClass> employeelist) {
		this.employeelist = employeelist;
	}
	
	

}






















