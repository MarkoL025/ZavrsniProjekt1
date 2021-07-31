package com.iktpreobuka.projectfinal.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
@Table(name = "Student")
//@PrimaryKeyJoinColumn(name = "StudentID")
public class StudentEntity extends UserEntity {

	@NotNull
	private String name;
	private String surname;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
	private ParentEntity parent;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<GradeEntity> Grades; 
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolClass")
	private SchoolClassEntity schoolClass;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "Student_Subject", joinColumns = {@JoinColumn(name = "Student_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "Subject_id", nullable = false, updatable = false)})
	protected Set<SubjectEntity> subjects = new HashSet<SubjectEntity>();
	
	public StudentEntity() {
		super();
	}

	public StudentEntity(Integer id, String username, String password, String name, String surname) {
		super(id, username, password);
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	

}
