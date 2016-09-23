package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IPatientsDao;
import com.cn.hwyl.pojo.Patients;
import com.cn.hwyl.service.IPatientsService;


@Service("patientsService")
public class PatientsServiceImpl implements IPatientsService {
	
	@Resource
	private IPatientsDao patientsDao;
	
	@Override
	public int deleteByPrimaryKey(String cPatientsid) {
		return patientsDao.deleteByPrimaryKey(cPatientsid);
	}

	@Override
	public int insert(Patients record) {
		return patientsDao.insert(record);
	}

	@Override
	public int insertSelective(Patients record) {
		return patientsDao.insertSelective(record);
	}

	@Override
	public Patients selectByPrimaryKey(String cPatientsid) {
		return patientsDao.selectByPrimaryKey(cPatientsid);
	}

	@Override
	public int updateByPrimaryKeySelective(Patients record) {
		return patientsDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Patients record) {
		return patientsDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(Patients record) {
		return patientsDao.saveOrUpdate(record);
	}
	 

}
