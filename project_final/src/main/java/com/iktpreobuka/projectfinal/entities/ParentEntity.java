package com.iktpreobuka.projectfinal.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
//@PrimaryKeyJoinColumn(name = "Parent_id")
@Table(name = "Parent")
public class ParentEntity extends UserEntity{
	
	private String name;
	private String surname;
	private String email;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	public List<StudentEntity> students; 
	
	public ParentEntity() {
		super();
	
	}

	public ParentEntity(Integer id, String username, String password, String name, String surname, String email) {
		super(id, username, password);
		this.name = name;
		this.surname = surname;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
