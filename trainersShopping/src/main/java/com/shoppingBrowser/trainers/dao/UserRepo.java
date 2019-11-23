package com.shoppingBrowser.trainers.dao;



import org.springframework.data.repository.CrudRepository;

import com.shoppingBrowser.trainers.model.User;


public interface UserRepo extends CrudRepository<User, String> {
	

		User findByUserName(String userName);
	 
	 
}
