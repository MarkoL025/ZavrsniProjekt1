package com.iktpreobuka.projectfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.projectfinal.entities.ParentEntity;
import com.iktpreobuka.projectfinal.entities.TeacherEntity;
import com.iktpreobuka.projectfinal.repositories.ParentRepository;

@RestController
@RequestMapping(path = "/api/v1/parents")
public class ParentController {
	
	@Autowired
	private ParentRepository parentRepository;


	@RequestMapping(method = RequestMethod.POST)
	public ParentEntity createParent(@RequestParam String username, @RequestParam String password, @RequestParam String name, 
			@RequestParam String surname, @RequestParam String email) {
		ParentEntity parent = new ParentEntity();
		parent.setUsername(username);
		parent.setPassword(password);
		parent.setName(name);
		parent.setSurname(surname);
		parent.setEmail(email);
		parentRepository.save(parent);
		return parent;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ParentEntity> getAllParents() {
		return parentRepository.findAll();
	}
}	