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

import com.offiqlassignment.entity.CustomUser;
import com.offiqlassignment.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public String create(@Valid @RequestBody CustomUser customUser, BindingResult result) {
		
		String errors="";
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error:allErrors) {
				errors=errors+error.getDefaultMessage()+"\n";
			}
			return errors.substring(0, errors.length()-1);
		}
		return this.userService.createUser(customUser);
		
	}
	
	@GetMapping("/users")
	public List<CustomUser> customUsers(){
		
		return this.userService.customUsers();
		
	}
	
	@GetMapping("/user/{id}")
	public CustomUser getUser(@PathVariable("id") int id){
		
		return this.userService.getUser(id);
		
	}
	
}
