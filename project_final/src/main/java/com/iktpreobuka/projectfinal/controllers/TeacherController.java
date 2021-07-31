package com.iktpreobuka.projectfinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.projectfinal.entities.ParentEntity;
import com.iktpreobuka.projectfinal.entities.StudentEntity;
import com.iktpreobuka.projectfinal.entities.TeacherEntity;
import com.iktpreobuka.projectfinal.repositories.TeacherRepository;

@RestController
@RequestMapping(path = "/api/v1/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository;


	@RequestMapping(method = RequestMethod.POST)
	public TeacherEntity createTeacher(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String surname ) {
		TeacherEntity teacher = new TeacherEntity();
		teacher.setUsername(username);
		teacher.setPassword(password);
		teacher.setName(name);
		teacher.setSurname(surname);
		teacherRepository.save(teacher);
		return teacher;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<TeacherEntity> getAllTeachers() {
		return teacherRepository.findAll();
	}
}
	