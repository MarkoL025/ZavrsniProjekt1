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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
@Table(name = "Subjects")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Subject_id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private ESubjects name;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "Student_Subject", joinColumns = {@JoinColumn(name = "Subject_id", nullable = false, updatable = false)},
	inverseJoinColumns = {@JoinColumn(name = "Student _id", nullable = false, updatable = false)})
	protected Set<StudentEntity> students = new HashSet<StudentEntity>();
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<GradeEntity> grades;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "Teacher_Subject", joinColumns = {@JoinColumn(name = "Subject_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "Teacher_id", nullable = false, updatable = false)})
	protected Set<TeacherEntity> teachers = new HashSet<TeacherEntity>();
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "SchoolClass_Subject", joinColumns = {@JoinColumn(name = "Subject_id", nullable = false, updatable = false)},
	inverseJoinColumns = {@JoinColumn(name = "SchoolClass_id", nullable = false, updatable = false)})
	protected Set<SchoolClassEntity> SchoolClasses = new HashSet<SchoolClassEntity>();
	
	@Column(name = "weekly_hours")
	private Integer weeklyHours;
	
	public SubjectEntity() {
		super();
		
	}
	
	public SubjectEntity(Integer id, ESubjects name, Integer weeklyHours) {
		super();
		this.id = id;
		this.name = name;
		this.weeklyHours = weeklyHours;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ESubjects getName() {
		return name;
	}
	public void setName(ESubjects name) {
		this.name = name;
	}
	public Integer getWeeklyHours() {
		return weeklyHours;
	}
	public void setWeeklyHours(Integer weeklyHours) {
		this.weeklyHours = weeklyHours;
	}
	

	
	
}
