package com.userdatabase.userdemo.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.userdatabase.userdemo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	@Query("{'username' : ?0 }")
	User findByUsername(String username);
}
