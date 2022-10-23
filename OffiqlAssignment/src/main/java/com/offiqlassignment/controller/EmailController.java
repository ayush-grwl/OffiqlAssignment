package com.offiqlassignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offiqlassignment.entity.Email;
import com.offiqlassignment.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/email")
	public String create(@Valid @RequestBody Email email, BindingResult result) {
		
		String errors="";
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error:allErrors) {
				errors=errors+error.getDefaultMessage()+"\n";
			}
			return errors.substring(0, errors.length()-1);
		}
		return this.emailService.create(email);
		
	}
	
	@GetMapping("/count/{userId}")
	public String countEmail(@PathVariable("userId") int id) {
		
		return this.emailService.numberOfEmails(id);
		
	}
	
}
