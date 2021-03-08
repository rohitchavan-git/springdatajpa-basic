package com.rohit.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.sbb.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
