package com.apiusers.demo;

import org.springframework.data.repository.CrudRepository;

import com.apiusers.demo.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}