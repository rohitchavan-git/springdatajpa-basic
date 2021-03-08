package com.rohit.sbb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "ETYPE")
public class Employee extends AbstractPerson {
	
	private String job;
	private Long salary;

	/**
	 * 
	 * one to one --->eager one to many --->lazy many to one --->eager many to many
	 * ---->lazy
	 * 
	 * 
	 */

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Document> documents;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
	private List<Project> project;

	public void setDoc(Document doct) {
		if (documents != null) {
			doct.setEmployee(this);
			documents.add(doct);
			return;
		}
		documents = new ArrayList<>();
		doct.setEmployee(this);
		documents.add(doct);

	}

	public void setPro(Project pro) {
		if (project != null) {
			project.add(pro);
			return;
		}
		project = new ArrayList<>();
		project.add(pro);

	}

}
