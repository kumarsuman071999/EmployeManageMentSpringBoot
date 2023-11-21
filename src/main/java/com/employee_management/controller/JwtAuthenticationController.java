package com.employee_management.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.entity.Employee;
import com.employee_management.entity.JwtAuthRequest;
import com.employee_management.entity.JwtAuthResponse;
import com.employee_management.exception.EmployeeUtils;
import com.employee_management.security.JwtTokenHelper;
import com.employee_management.service.JwtUserDetailService;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private JwtUserDetailService jwtUserDetailService;
	
	@CrossOrigin(origins ="http://localhost:3000")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<JwtAuthResponse> createAuthenticationToken(@RequestBody JwtAuthRequest jwtAuthRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtAuthRequest.getUsername(),jwtAuthRequest.getPassword()));
			
		} catch (BadCredentialsException e) {

			return new ResponseEntity<JwtAuthResponse>(new JwtAuthResponse("Invalid username or password",""),HttpStatus.UNAUTHORIZED);

		
		}
		
		final UserDetails userDetails=jwtUserDetailService.loadUserByUsername(jwtAuthRequest.getUsername());
		
		String jwt=jwtTokenHelper.generateToken(userDetails);
		String role=userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

		return new ResponseEntity<JwtAuthResponse>(new JwtAuthResponse(jwt,role),HttpStatus.CREATED);
	}
	
	
	
	
	
	

}
