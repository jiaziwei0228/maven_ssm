package com.jzw.dao.impl;

import java.util.List;

import javax.annotation.Resource;




import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.jzw.dao.IUserDao;
import com.jzw.model.User;
import com.jzw.model.UserException;
@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport implements IUserDao{

	
	@Resource
	 public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
		super.setSqlSessionFactory(sessionFactory);
	}
	@Override
	public User login(User user) throws UserException {
		return getSqlSession().getMapper(IUserDao.class).login(user);
	}

	@Override
	public List<User> list() {
		return getSqlSession().getMapper(IUserDao.class).list();
	}
	@Override
	public void add(User user) {
		 getSqlSession().getMapper(IUserDao.class).add(user);
		
	}
	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IUserDao.class).delete(id);
		
	}
	@Override
	public void update(User user) {
		getSqlSession().getMapper(IUserDao.class).update(user);
		
	}

}
