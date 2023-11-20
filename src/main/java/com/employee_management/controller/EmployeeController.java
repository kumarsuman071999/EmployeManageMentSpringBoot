package com.employee_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_management.entity.Employee;
import com.employee_management.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	

	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee=employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee updatEmployee=employeeService.updateEmployee(id, employeeDetails);
		return ResponseEntity.ok(updatEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id){
		Map<String, Boolean> response=employeeService.deleteEmployeeById(id);
		return ResponseEntity.ok(response);
	}
	
	// change password
	@PostMapping("/employees/password")
	ResponseEntity<String> changePassword(@RequestBody Map<String, String> requestMap){
		return employeeService.changePassword(requestMap);
	}
	

	// signup
	@PostMapping("/employees/signup")
	ResponseEntity<String> signUp(@RequestBody Map<String, String> requestMap){
		return employeeService.signUp(requestMap);
	}
	
	

}
