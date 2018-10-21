package com.userdatabase.userdemo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdatabase.userdemo.database.TokenRepository;
import com.userdatabase.userdemo.entity.UserToken;
import com.userdatabase.userdemo.exception.TokenNotActiveException;

@Service
public class TokenService {

	@Autowired
	TokenRepository tokenRepository;

	public UserToken createToken(String userId) {
		long time = new Date().getTime();
		UserToken token = new UserToken();
		token.setUserId(userId);
		token.setActive(true);
		token.setToken(String.format("UT-%s-%s", userId, time));
		tokenRepository.save(token);
		return token;
	}

	public UserToken readToken(String tokenId) {

		Optional<UserToken> token = tokenRepository.findById(tokenId);

		if (!token.isPresent()) {
			throw new TokenNotActiveException("Token not found");
		}
		return token.get();
	}

	public void logout(String tokenId) {
		UserToken token = readToken(tokenId);
		token.setActive(false);
		tokenRepository.save(token);
	}
}
