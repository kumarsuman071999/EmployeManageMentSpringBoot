//package com.employee_management.data;
//
//import org.apache.commons.logging.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.employee_management.entity.Employee;
//import com.employee_management.entity.User;
//import com.employee_management.repo.EmployeeRepo;
//import com.employee_management.repo.UserRepository;
//
//@Component
//public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {
//
//	@Autowired
//	private UserRepository userDao;
//	
//	@Autowired
//	private EmployeeRepo employeeRepo;
//	
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//	
//	
//	@Override
//	public void onApplicationEvent(ApplicationReadyEvent event) {
//		
//		try {
//			User user=new User("usr1",bcryptEncoder.encode("pwd"),"USER");
//			userDao.save(user);
//			
//			user=new User("admin",bcryptEncoder.encode("admin"),"ADMIN");
//			userDao.save(user);
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
