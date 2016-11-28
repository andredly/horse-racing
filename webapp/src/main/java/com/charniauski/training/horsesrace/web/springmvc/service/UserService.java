package com.charniauski.training.horsesrace.web.springmvc.service;

import com.charniauski.training.horsesrace.web.springmvc.model.User;

import java.util.List;




public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
