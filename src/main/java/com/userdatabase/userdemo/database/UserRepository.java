package com.userdatabase.userdemo.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userdatabase.userdemo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	// User findByEmailAddress(String email);
	//
	// User findByPhoneNo(String phoneNo);

}
