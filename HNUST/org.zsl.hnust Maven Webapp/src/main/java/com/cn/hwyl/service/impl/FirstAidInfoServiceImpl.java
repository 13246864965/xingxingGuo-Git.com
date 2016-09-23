package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IFirstAidInfoDao;
import com.cn.hwyl.pojo.FirstAidInfo;
import com.cn.hwyl.service.IFirstAidInfoService;

@Service("firstAidInfoService")
public class FirstAidInfoServiceImpl implements IFirstAidInfoService{

	@Resource
	private IFirstAidInfoDao firstAidInfoDao;
	
	@Override
	public int deleteByPrimaryKey(String cFirstaidinfoid) {
		return firstAidInfoDao.deleteByPrimaryKey(cFirstaidinfoid);
	}

	@Override
	public int insert(FirstAidInfo record) {
		
		return firstAidInfoDao.insert(record);
	}


	@Override
	public FirstAidInfo selectByPrimaryKey(String cFirstaidinfoid) {
		return firstAidInfoDao.selectByPrimaryKey(cFirstaidinfoid);
	}

	@Override
	public int updateByPrimaryKey(FirstAidInfo record) {
		return firstAidInfoDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(FirstAidInfo record)  {
		return firstAidInfoDao.saveOrUpdate(record);
	}


}
