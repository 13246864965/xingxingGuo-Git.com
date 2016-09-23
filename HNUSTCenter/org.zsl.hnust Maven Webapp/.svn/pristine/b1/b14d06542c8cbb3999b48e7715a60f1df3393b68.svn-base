package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IConsultationInfoDao;
import com.cn.hwyl.pojo.ConsultationInfo;
import com.cn.hwyl.service.IConsultationInfoService;

@Service("consultationInfoService")
public class ConsultationInfoServiceImpl implements IConsultationInfoService{

	@Resource
	private IConsultationInfoDao consultationInfoDao;
	
	@Override
	public int deleteByPrimaryKey(String cConsultationid) {
		return consultationInfoDao.deleteByPrimaryKey(cConsultationid);
	}

	@Override
	public int insert(ConsultationInfo record) {
		return consultationInfoDao.insert(record);
	}

	@Override
	public int insertSelective(ConsultationInfo record) {
		return consultationInfoDao.insertSelective(record);
	}

	@Override
	public ConsultationInfo selectByPrimaryKey(String cConsultationid) {
		return consultationInfoDao.selectByPrimaryKey(cConsultationid);
	}

	@Override
	public int updateByPrimaryKeySelective(ConsultationInfo record) {
		return consultationInfoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(ConsultationInfo record) {
		return consultationInfoDao.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(ConsultationInfo record) {
		return consultationInfoDao.updateByPrimaryKey(record);
	}

}
