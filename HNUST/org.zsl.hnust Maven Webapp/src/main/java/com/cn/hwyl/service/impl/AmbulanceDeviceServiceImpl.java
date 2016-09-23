package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IAmbulanceDeviceDao;
import com.cn.hwyl.pojo.AmbulanceDevice;
import com.cn.hwyl.service.IAmbulanceDeviceService;

@Service("ambulanceDeviceService")
public class AmbulanceDeviceServiceImpl implements IAmbulanceDeviceService{
	
	@Resource
	private IAmbulanceDeviceDao ambulanceDeviceDao;
	

	@Override
	public int deleteByPrimaryKey(String cAdid) {
		return ambulanceDeviceDao.deleteByPrimaryKey(cAdid);
	}

	@Override
	public int insert(AmbulanceDevice record) {
		return ambulanceDeviceDao.insert(record);
	}

	@Override
	public AmbulanceDevice selectByPrimaryKey(String cAdid) {
		return ambulanceDeviceDao.selectByPrimaryKey(cAdid);
	}

	@Override
	public int updateByPrimaryKey(AmbulanceDevice record) {
		return ambulanceDeviceDao.updateByPrimaryKey(record);
	}

	@Override
	public List<AmbulanceDevice> selectByPage(AmbulanceDevice record) {
		return ambulanceDeviceDao.selectByPage(record);
	}

	@Override
	public int selectByCount(AmbulanceDevice record) {
		return ambulanceDeviceDao.selectByCount(record);
	}
	

}
