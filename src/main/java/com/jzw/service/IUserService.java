package com.jzw.service;

import java.util.List;

import com.jzw.model.User;
import com.jzw.model.UserException;

public interface IUserService {
public User login(User user) throws UserException;
public List<User> list();
public void add(User user);
public void delete(int id);
public void update(User user);
}
