package com.employee_management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_management.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	Employee  findByUsername(String username);

}
