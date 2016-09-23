package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IFirstaidHistoryDao;
import com.cn.hwyl.pojo.FirstaidHistory;
import com.cn.hwyl.service.IFirstaidHistoryService;

@Service("firstaidHistoryService")
public class FirstaidHistoryServiceImpl implements IFirstaidHistoryService{

	@Resource
	private IFirstaidHistoryDao firstaidHistoryDao;
	
	@Override
	public int deleteByPrimaryKey(String cFirstaidid) {
		return firstaidHistoryDao.deleteByPrimaryKey(cFirstaidid);
	}

	@Override
	public int insert(FirstaidHistory record) {
		return firstaidHistoryDao.insert(record);
	}

	@Override
	public FirstaidHistory selectByPrimaryKey(String cFirstaidid) {
		return firstaidHistoryDao.selectByPrimaryKey(cFirstaidid);
	}

	@Override
	public int updateByPrimaryKey(FirstaidHistory record) {
		return firstaidHistoryDao.updateByPrimaryKey(record);
	}

}
