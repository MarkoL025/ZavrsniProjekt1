package com.iktpreobuka.projectfinal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.projectfinal.entities.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
