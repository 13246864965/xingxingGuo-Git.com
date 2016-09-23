package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IFirstaidTaskDao;
import com.cn.hwyl.pojo.FirstaidTask;
import com.cn.hwyl.service.IFirstaidTaskService;

@Service("firstaidTaskService")
public class FirstaidTaskServiceImpl implements IFirstaidTaskService{
	@Resource
	private IFirstaidTaskDao firstaidTaskDao;

	@Override
	public int deleteByPrimaryKey(String cTaskid) {
		return firstaidTaskDao.deleteByPrimaryKey(cTaskid);
	}

	@Override
	public int insert(FirstaidTask record) {
		return firstaidTaskDao.insert(record);
	}

	@Override
	public int insertSelective(FirstaidTask record) {
		return firstaidTaskDao.insertSelective(record);
	}

	@Override
	public FirstaidTask selectByPrimaryKey(String cTaskid) {
		return firstaidTaskDao.selectByPrimaryKey(cTaskid);
	}

	@Override
	public int updateByPrimaryKeySelective(FirstaidTask record) {
		return firstaidTaskDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FirstaidTask record) {
		return firstaidTaskDao.updateByPrimaryKey(record);
	}

	@Override
	public List<FirstaidTask> selectByPage(FirstaidTask record) {
		return firstaidTaskDao.selectByPage(record);
	}

	@Override
	public int selectByPageCount(FirstaidTask record) {
		return firstaidTaskDao.selectByPageCount(record);
	}

	@Override
	public int saveOrUpdate(FirstaidTask record) {
		return firstaidTaskDao.saveOrUpdate(record);
	}

}
