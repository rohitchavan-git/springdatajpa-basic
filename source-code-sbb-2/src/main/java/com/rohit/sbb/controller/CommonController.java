package com.rohit.sbb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.sbb.entity.Address;
import com.rohit.sbb.entity.Document;
import com.rohit.sbb.entity.InternEmployee;
import com.rohit.sbb.entity.Project;
import com.rohit.sbb.pojo.EmployeePojo;
import com.rohit.sbb.repository.EmployeeRepo;
import com.rohit.sbb.repository.InternEmpolyeeRepo;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CommonController {

	
	private final EmployeeRepo employeeRepo;
	
	private final InternEmpolyeeRepo internRepo;
	

	@PostMapping("/save")
	public void saveEmployee() {
		
		
		InternEmployee intern = new InternEmployee();

		intern.setFname("rahul");
		intern.setLname("chavan");
		intern.setSalary(100000L);
		intern.setJob("manager");
		intern.setBoud(6L);
		Address address = new Address();
		address.setCity("Nanded");
		address.setState("MH");
		address.setHomeNo("1234");
		intern.setAddress(address);
		Document document = new Document();
		document.setDocName("aadar card");
		intern.setDoc(document);
		Project pro = new Project();
		pro.setProjectName("NFT");
		intern.setPro(pro);
				
		internRepo.save(intern);
		
	}
	
	
	@GetMapping("/getData")
	public InternEmployee getData() {
		
	return	internRepo.findById(9L).get();
		
	}
	
	@GetMapping("/getFullname")
	public List<Object> getFullname() {
		
		List<Map<String, Object>> fullName = internRepo.getFullName();
		
		return fullName
				.stream()
				.flatMap(i->i.entrySet().stream().map(j->j.getValue()))
				.collect(Collectors.toList());
	
	}
	
	
	@GetMapping("/getFullnameWithState")
	public List<EmployeePojo> getFullnameWithState() {
		return internRepo.findByName("rohit", EmployeePojo.class);
	}
	
}
