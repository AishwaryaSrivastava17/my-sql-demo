package com.example.mysqldemo.service;

import java.util.List;
import java.util.Optional;

import com.example.mysqldemo.entity.User;

public interface IuserService {

 int save(User user);

List<User> getUsers();

void updateUser(User user);

Optional<User> getUser(Integer userId);

void deleteUser(Integer userId);



}
