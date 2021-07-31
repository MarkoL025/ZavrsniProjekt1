package com.iktpreobuka.projectfinal.entities;

import java.time.LocalDate;

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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class GradeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Column(name = "Grade")
	@Size(min = 1, max = 5, message = "Grade must be between {min} and {max}.")
	private Integer grade;
	
	@Column(name = "Grade_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private LocalDate gradeDate;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name = "Grade_type")
	private EGradeType gradeType;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	@Column(name = "Semester")
	private ESemester semester;
	
	@Column(name = "Final")
	private boolean isFinal;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "student")
	private StudentEntity student; 
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity subject;

	public GradeEntity() {
		super();
	}
	public GradeEntity(Integer id, Integer grade, LocalDate gradeDate, EGradeType gradeType, ESemester semester, boolean isFinal) {
		super();
		this.id = id;
		this.grade = grade;
		this.gradeDate = gradeDate;
		this.gradeType = gradeType;
		this.semester = semester;
		this.isFinal = isFinal;
	
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public LocalDate getGradeDate() {
		return gradeDate;
	}
	public void setGradeDate(LocalDate gradeDate) {
		this.gradeDate = gradeDate;
	}
	public EGradeType getGradeType() {
		return gradeType;
	}
	public void setGradeType(EGradeType gradeType) {
		this.gradeType = gradeType;
	}
	public ESemester getSemester() {
		return semester;
	}
	public void setSemester(ESemester semester) {
		this.semester = semester;
	}
	
	public boolean isFinal() {
		return isFinal;
	}
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
	
}
