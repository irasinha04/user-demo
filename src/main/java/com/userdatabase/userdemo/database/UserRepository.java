package com.userdatabase.userdemo.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userdatabase.userdemo.entity.Users;

public interface UserRepository extends MongoRepository<Users, String> {
	Users findByUsername(String username);
}
