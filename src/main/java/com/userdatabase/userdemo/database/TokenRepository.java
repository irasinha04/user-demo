package com.userdatabase.userdemo.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userdatabase.userdemo.entity.UserToken;

public interface TokenRepository extends MongoRepository<UserToken, String> {

}
