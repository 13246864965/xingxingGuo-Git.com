package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IUserDao;
import com.cn.hwyl.pojo.User;
import com.cn.hwyl.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;
	
	@Override
	public int deleteByPrimaryKey(String cUserid) {
		return userDao.deleteByPrimaryKey(cUserid);
	}
	@Override
	public int insert(User record) {
		return userDao.insert(record);
	}
	@Override
	public User selectByPrimaryKey(String cUserid) {
		return userDao.selectByPrimaryKey(cUserid);
	}
	@Override
	public int updateByPrimaryKey(User record) {
		return 0;
	}
	@Override
	public User selectByUsername(String username) {
		return null;
	}
	@Override
	public List<User> selectByPage(User user) {
		return userDao.selectByPage(user);
	}
	@Override
	public int selectByPageCount(User user) {
		return userDao.selectByPageCount(user);
	}
	@Override
	public User selectByCusername(String cUsername) {
		return userDao.selectByCusername(cUsername);
	}
	@Override
	public int saveOrUpdate(User record) {
		return userDao.saveOrUpdate(record);
	}

}
