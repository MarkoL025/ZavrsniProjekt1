package com.iktpreobuka.projectfinal.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@PrimaryKeyJoinColumn(name = "Teacher_id")
public class TeacherEntity extends UserEntity{
	
	private String name;
	private String surname;
	
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Subject", joinColumns = {@JoinColumn(name = "Teacher_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "Subject_id", nullable = false, updatable = false)})
	protected Set<SubjectEntity> subjects = new HashSet<SubjectEntity>();
	
	
	public TeacherEntity(Integer id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
	}

	public TeacherEntity() {
		super();
		
	}
	public TeacherEntity(Integer id, String username, String password, String name, String surname) {
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
