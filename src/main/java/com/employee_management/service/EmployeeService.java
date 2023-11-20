package com.employee_management.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee_management.entity.Employee;
import com.employee_management.exception.EmployeeUtils;
import com.employee_management.exception.ResourceNotFoundException;
import com.employee_management.repo.EmployeeRepo;
import com.employee_management.security.FilterController;

import io.jsonwebtoken.Jwt;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired FilterController filterController;
	
	

	
	// get all employee 
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	
	// create employee
	public Employee createEmployee(@RequestBody Employee employee) throws ResourceNotFoundException{
	
		return employeeRepo.save(employee);
	}
	
	// get employee by id
	public Employee getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException{
		Employee employee=employeeRepo.findById(id).orElseThrow(( )-> new ResourceNotFoundException("Employee not exist with id:" +id));
		return employee;
	}
	
	// update employee
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
		Employee employee=employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setDob(employeeDetails.getDob());
		employee.setAddress(employeeDetails.getAddress());
		employee.setCity(employeeDetails.getCity());
		employee.setState(employeeDetails.getState());
		employee.setZipcode(employeeDetails.getZipcode());
		employee.setMobileNo(employeeDetails.getMobileNo());
		employee.setDepartmment(employeeDetails.getDepartmment());
		employee.setEmployeeId(employeeDetails.getEmployeeId());
		employee.setRole(employeeDetails.getRole());
		employee.setPassword(employeeDetails.getPassword());
		employee.setUsername(employeeDetails.getUsername());
		
		
		Employee updateEmployee=employeeRepo.save(employee);
		return updateEmployee;
	}
	
	
//	// register new user
//	public User registerNewUser(@RequestBody User user) throws ResourceNotFoundException{
//		return userRepository.save(user);
//	}
	
// update password
	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		try {
			Employee employeeobj=employeeRepo.findByUsername(filterController.getCurrentUser());
			if(!employeeobj.equals(null)) {
				if(employeeobj.getPassword().equals(requestMap.get("oldPassword"))) {
					employeeobj.setPassword(requestMap.get("newPassword"));
					employeeRepo.save(employeeobj);
					return EmployeeUtils.getResponseEntity("password updated successfully", HttpStatus.OK);
				}
				return EmployeeUtils.getResponseEntity("Incorrect old password", HttpStatus.BAD_REQUEST);
			}
			return EmployeeUtils.getResponseEntity("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return EmployeeUtils.getResponseEntity("something went wromg",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// delete employee by id
	public Map<String,Boolean> deleteEmployeeById(@PathVariable Long id) throws ResourceNotFoundException{
		Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" + id));
		employeeRepo.delete(employee);
		Map<String, Boolean> response= new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	// signup
	public ResponseEntity<String> signUp( Map<String, String> requestMap){
		if(validateSignUpMap(requestMap)) {
			Employee employee=employeeRepo.findByUsername(requestMap.get("username"));
			if(Objects.isNull(employee)) {
				employeeRepo.save(getUserFromMap(requestMap));
				
			}
			else {
				return EmployeeUtils.getResponseEntity("Email already exist", HttpStatus.BAD_REQUEST);
			}
			
		}
		else {
			EmployeeUtils.getResponseEntity("Invalid data", HttpStatus.BAD_REQUEST);
		}
		return null;
		
	}
	
	// validate signup app
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("username") && requestMap.containsKey("password") && requestMap.containsKey("role") && requestMap.containsKey("firstName") && requestMap.containsKey("lastName")  && requestMap.containsKey("employeeId") && requestMap.containsKey("departmment") )  {
			return true;
		}
		return false;
	}
	
	// exract value from map set it to map and return user object
	private Employee getUserFromMap(Map<String, String> requestMap) {	
		Employee employee=new Employee();
		employee.setUsername(requestMap.get("username"));
		employee.setPassword(requestMap.get("password"));
		employee.setRole(requestMap.get("role"));
		employee.setFirstName(requestMap.get("firstName"));
		employee.setLastName(requestMap.get("lastName"));
		employee.setEmployeeId(requestMap.get("employeeId"));
		employee.setDepartmment(requestMap.get("departmment"));
		return employee;
	}

}
