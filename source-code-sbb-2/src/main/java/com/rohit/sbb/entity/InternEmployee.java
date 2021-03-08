package com.rohit.sbb.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("INTERN")
@Entity
public class InternEmployee  extends Employee{

	private Long boud;
}
