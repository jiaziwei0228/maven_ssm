package com.jzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzw.dao.IUserDao;
import com.jzw.model.User;
import com.jzw.model.UserException;
import com.jzw.service.IUserService;
@Service("userService")
public class UserService implements IUserService{
private IUserDao userDao;

	public UserService() {
	super();
}

	public UserService(IUserDao userDao) {
	super();
	this.userDao = userDao;
}

	public IUserDao getUserDao() {
	return userDao;
}
@Autowired
public void setUserDao(IUserDao userDao) {
	this.userDao = userDao;
}

	@Override
	public User login(User user) throws UserException{
		User loginUser=userDao.login(user);
		if(loginUser==null){
			throw new UserException("用户名不存在！！！");
		}
		if(!loginUser.getPassword().trim().equals(user.getPassword().trim())){
			throw new UserException("密码错误！！！");
		}
		return loginUser;
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		
	}

	@Override
	public void update(User user) {
		
		userDao.update(user);
	}

}
