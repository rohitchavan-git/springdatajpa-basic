package com.rohit.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.sbb.entity.PerEmployee;

public interface PerEmployeeRepo extends JpaRepository<PerEmployee, Long> {

}
