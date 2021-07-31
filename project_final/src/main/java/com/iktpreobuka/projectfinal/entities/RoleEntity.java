package com.iktpreobuka.projectfinal.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
@Table(name = "Role")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Role_Id")
	private Integer id;
	
	@Column(name = "Role_name")
	private Erole name;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserEntity> users = new ArrayList<>();
	
	
	public RoleEntity() {
		super();
	}
	public RoleEntity(Integer id, Erole name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Erole getName() {
		return name;
	}
	public void setName(Erole name) {
		this.name = name;
	}
	
	
}
