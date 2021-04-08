package com.example.mysqldemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysqldemo.entity.User;

public interface Userrepository extends JpaRepository<User,Integer>{
	
}
