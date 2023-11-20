package com.employee_management.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	


	private String firstName;
	
	private String lastName;
	
	
	private Date dob;
	
	private  String address;
	
	private String city;
	
	private String state;
	
	private String zipcode;
	
	private String email;
	
	private long mobileNo;
	
	private String departmment;
	
	private String employeeId;
	
	@Column(unique = true)
	private String username;
	

	private String password;
	
	private String role;
	
	public Employee() {
		
	}

	

	
	
	

	public Employee(String firstName, String lastName, Date dob, String address, String city, String state,
			String zipcode, String email, long mobileNo, String departmment, String employeeId, String username,
			String password, String role) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.mobileNo = mobileNo;
		this.departmment = departmment;
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
		this.role = role;
	}







	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDepartmment() {
		return departmment;
	}

	public void setDepartmment(String departmment) {
		this.departmment = departmment;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}







	public String getUsername() {
		return username;
	}







	public void setUsername(String username) {
		this.username = username;
	}







	public String getPassword() {
		return password;
	}







	public void setPassword(String password) {
		this.password = password;
	}







	public String getRole() {
		return role;
	}







	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
	
	
	
	
	 
	
	

}
