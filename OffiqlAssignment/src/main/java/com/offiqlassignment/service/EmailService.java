package com.offiqlassignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offiqlassignment.dao.EmailRepository;
import com.offiqlassignment.dao.UserRepository;
import com.offiqlassignment.entity.CustomUser;
import com.offiqlassignment.entity.Email;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String create(Email email) {
		
		try {
			Email savedEmail = this.emailRepository.save(email);
			if(savedEmail!=null) {
				return "Email Saved Successfully";
			}
			return "Error!!";
		}catch(Exception e) {
			return "Error!!";
		}
		
	}
	
	public String numberOfEmails(int id) {
		
		CustomUser user=this.userRepository.findById(id).get();
		return "Total Number Of Emails = "+this.emailRepository.findByFromUser(user.getFirstName()+" "+user.getLastName()).size();
		
	}
	
}
