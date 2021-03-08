package com.rohit.sbb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rohit.sbb.entity.InternEmployee;

public interface InternEmpolyeeRepo extends JpaRepository<InternEmployee, Long>{

	
	@Query("select new Map(i.fname as first_name , i.lname as last_name) "
			+ "from InternEmployee i")
	public List<Map<String,Object>> getFullName();
	
	@Query("select i from InternEmployee i where i.fname=:name ")
	public <T> List<T> findByName(@Param("name") String name,Class<T> type);
	
	
	
	
}
