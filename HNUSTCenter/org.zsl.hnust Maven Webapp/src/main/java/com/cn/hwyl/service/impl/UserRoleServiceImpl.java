package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IUserRoleDao;
import com.cn.hwyl.pojo.User;
import com.cn.hwyl.pojo.UserRole;
import com.cn.hwyl.service.IUserRoleService;


@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService{

	@Resource
	private IUserRoleDao userRoleDao;
	
	@Override
	public int deleteByPrimaryKey(String cUserroleid) {
		return userRoleDao.deleteByPrimaryKey(cUserroleid);
	}

	@Override
	public int insert(UserRole record) {
		return userRoleDao.insert(record);
	}

	@Override
	public int insertSelective(UserRole record) {
		return userRoleDao.insertSelective(record);
	}

	@Override
	public UserRole selectByPrimaryKey(String cUserroleid) {
		return userRoleDao.selectByPrimaryKey(cUserroleid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserRole record) {
		return userRoleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserRole record) {
		return userRoleDao.updateByPrimaryKey(record);
	}
}
