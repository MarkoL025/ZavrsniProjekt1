package com.iktpreobuka.projectfinal.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.projectfinal.entities.ParentEntity;
import com.iktpreobuka.projectfinal.entities.StudentEntity;
import com.iktpreobuka.projectfinal.entities.UserEntity;
import com.iktpreobuka.projectfinal.repositories.StudentRepository;


@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public StudentEntity createStudent(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String surname ) {
		StudentEntity student = new StudentEntity();
		//student.setId((new Random()).nextInt());
		student.setUsername(username);
		student.setPassword(password);
		student.setName(name);
		student.setSurname(surname);
		studentRepository.save(student);
		return student;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}
}
