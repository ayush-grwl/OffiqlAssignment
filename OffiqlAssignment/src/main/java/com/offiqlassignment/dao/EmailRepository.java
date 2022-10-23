package com.offiqlassignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.offiqlassignment.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {
	
	public List<Email> findByFromUser(String name);

}
