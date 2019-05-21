package com.project.api.user.repository;

import com.project.api.user.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}