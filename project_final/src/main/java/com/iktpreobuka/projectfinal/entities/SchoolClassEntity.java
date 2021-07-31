package com.iktpreobuka.projectfinal.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "School_class")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class SchoolClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SchoolClass_id")
	private Integer id;
	
	@Min(value = 1, message = "Class number must be greater than {value}.")
	@Max(value = 8, message = "Class number must be lesser than than {value}.")
	@Column(name = "Class_number")
	private Integer ClassNo;
	
	@Column(name = "Class_section")
	@Enumerated(EnumType.STRING)
	private EClassSection classSection;
	
	@OneToMany(mappedBy = "schoolClass", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<StudentEntity> students;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "SchoolClass_Subject", joinColumns = {@JoinColumn(name = "SchoolClass_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "Subject_id", nullable = false, updatable = false)})
	protected Set<SubjectEntity> subjects = new HashSet<SubjectEntity>();
	
	public SchoolClassEntity() {
		super();
	}
	public SchoolClassEntity(Integer id, Integer classNo, EClassSection classSection) {
		super();
		this.id = id;
		this.ClassNo = classNo;
		this.classSection = classSection;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassNo() {
		return ClassNo;
	}
	public void setClassNo(Integer classNo) {
		ClassNo = classNo;
	}
	public EClassSection getClassSection() {
		return classSection;
	}
	public void setClassSection(EClassSection classSection) {
		this.classSection = classSection;
	}
	
	
}
