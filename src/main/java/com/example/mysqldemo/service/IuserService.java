package com.example.mysqldemo.service;

import java.util.List;
import com.example.mysqldemo.entity.User;

public interface IuserService {

 int save(User user);

List<User> getUsers();

void updateUser(User user);

void deleteUser(Integer userId);

List <User> getUserByName(String name);



}
