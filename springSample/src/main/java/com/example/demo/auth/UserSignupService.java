package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSignupService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void signupUser(User user) {
		int result = 0;
		
		// 1件INSERTされる
		result += userRepository.signupUser(user);
		
		// resultが1以外の場合
		if (result != 1) {
			throw new RuntimeException();
		}
	}
}
