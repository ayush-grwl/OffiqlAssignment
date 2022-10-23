package com.offiqlassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offiqlassignment.dao.UserRepository;
import com.offiqlassignment.entity.CustomUser;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public String createUser(CustomUser customUser) {
		
		try {
			CustomUser savedUser = this.userRepository.save(customUser);
			if(savedUser!=null) {
				return "User Saved Successfully";
			}
			return "Error!!";
		}catch(Exception e) {
			return "Error!!";
		}
		
	}
	
	public List<CustomUser> customUsers(){
		
		return this.userRepository.findAll();
		
	}
	
	public CustomUser getUser(int id) {
		
		return this.userRepository.findById(id).get();
		
	}
	
}
