package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IRoleDao;
import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService{

	@Resource
	private IRoleDao roleDao;
	
	@Override
	public int deleteByPrimaryKey(String cRoleid) {
		return roleDao.deleteByPrimaryKey(cRoleid);
	}

	@Override
	public int insert(Role record) {
		return roleDao.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		return roleDao.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(String cRoleid) {
		return roleDao.selectByPrimaryKey(cRoleid);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> selectByPage(Role record) {
		return roleDao.selectByPage(record);
	}

	@Override
	public int selectByCount(Role record) {
		return roleDao.selectByCount(record);
	}

}
