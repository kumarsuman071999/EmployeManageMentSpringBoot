package com.employee_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.employee_management.entity.Employee;
import com.employee_management.exception.ResourceNotFoundException;
import com.employee_management.repo.EmployeeRepo;

@Service
public class JwtUserDetailService implements UserDetailsService  {
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
	
		
		// load user from database in repository
		Employee employee=employeeRepo.findByUsername(username);
	
		
		if(!Objects.isNull(employee)) {
			List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
			SimpleGrantedAuthority authority=new SimpleGrantedAuthority(employee.getRole());
			authorities.add(authority);
			return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), authorities);

			
		}
		
		else {
			throw new UsernameNotFoundException("user not found with user name:" );
		}
		
		

//		
//		public Employee getUserDetail() {
//			return Employee;
//		}
		
		
	}
	
}
