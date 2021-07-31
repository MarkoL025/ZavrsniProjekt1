package com.iktpreobuka.projectfinal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.projectfinal.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
