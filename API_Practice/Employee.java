package API_Practice;

import java.util.Map;



public class Employee 
{
	
	/*
	{
		"Name": "Mandodri Singh",
		"gender": "Male",
		"age": 33,
		"salary": 21000.50,
		"IsMarried": true,
		"hobbies":
		[
			"Reading",
			"Music"
		],
		"familyMembers":
		{
			"1":"Mother",
			"2":"Father"
		}
	}
	 
	 */
	 
	private String Name;
	private String gender;
	private int age;
	private double salary;
	private boolean IsMarried;
	
	private String[] hobbies;
	private Map<String, String> familyMembers;
	
	
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
	
	

	
	

}
