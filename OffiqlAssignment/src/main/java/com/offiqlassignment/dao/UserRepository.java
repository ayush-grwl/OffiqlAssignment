package com.offiqlassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.offiqlassignment.entity.CustomUser;

public interface UserRepository extends JpaRepository<CustomUser, Integer>{

}
