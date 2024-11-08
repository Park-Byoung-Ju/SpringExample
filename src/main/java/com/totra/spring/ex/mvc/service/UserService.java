package com.totra.spring.ex.mvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totra.spring.ex.mvc.domain.User;
import com.totra.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
	}
	
	public User getLastUser(){
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	public int addUserByObject(User user) {
		int result = userRepository.insertUserByObject(user);
		
		return result;
	}
}
