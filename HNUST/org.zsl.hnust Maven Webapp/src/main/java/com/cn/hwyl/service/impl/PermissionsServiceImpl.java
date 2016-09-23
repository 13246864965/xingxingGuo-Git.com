package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IPermissionsDao;
import com.cn.hwyl.pojo.Permissions;
import com.cn.hwyl.service.IPermissionsService;

@Service("permissionsService")
public class PermissionsServiceImpl implements IPermissionsService{

	@Resource
	private IPermissionsDao permissionsDao;
	
	@Override
	public int deleteByPrimaryKey(String cPrivilegeid) {
		return permissionsDao.deleteByPrimaryKey(cPrivilegeid);
	}

	@Override
	public int insert(Permissions record) {
		return permissionsDao.insert(record);
	}


	@Override
	public Permissions selectByPrimaryKey(String cPrivilegeid) {
		return permissionsDao.selectByPrimaryKey(cPrivilegeid);
	}


	@Override
	public int updateByPrimaryKey(Permissions record) {
		return permissionsDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Permissions> selectByPage(Permissions record) {
		return permissionsDao.selectByPage(record);
	}

	@Override
	public int selectByCount(Permissions record) {
		return permissionsDao.selectByCount(record);
	}

}
