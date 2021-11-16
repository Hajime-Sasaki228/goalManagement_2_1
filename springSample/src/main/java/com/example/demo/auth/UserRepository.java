package com.example.demo.auth;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public User identifyUser(String email);
	
	// DBにユーザー情報を挿入する
	public int signupUser(User user);
}
