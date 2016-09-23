package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IDeviceUpdateDao;
import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.service.IDeviceUpdateService;


@Service("deviceUpdateService")
public class DeviceUpdateServiceImpl implements IDeviceUpdateService{

	
	@Resource
	private IDeviceUpdateDao deviceUpdateDao;
	
	@Override
	public int deleteByPrimaryKey(String cWardshipid) {
		return deviceUpdateDao.deleteByPrimaryKey(cWardshipid);
	}

	@Override
	public int insert(DeviceUpdate record) {
		return deviceUpdateDao.insert(record);
	}

	@Override
	public int insertSelective(DeviceUpdate record) {
		return deviceUpdateDao.insertSelective(record);
	}

	@Override
	public DeviceUpdate selectByPrimaryKey(String cWardshipid) {
		return deviceUpdateDao.selectByPrimaryKey(cWardshipid);
	}

	@Override
	public int updateByPrimaryKeySelective(DeviceUpdate record) {
		return deviceUpdateDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DeviceUpdate record) {
		return deviceUpdateDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(DeviceUpdate record) {
		return deviceUpdateDao.saveOrUpdate(record);
	}

}
