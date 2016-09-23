package com.cn.hwyl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IFollowUpVisitsDao;
import com.cn.hwyl.pojo.FollowUpVisits;
import com.cn.hwyl.service.IFollowUpVisitsService;

@Service("followUpVisitsService")
public class FollowUpVisitsServiceImpl implements IFollowUpVisitsService{
	@Resource
	private IFollowUpVisitsDao followUpVisitsDao;

	@Override
	public int deleteByPrimaryKey(Integer cVisitsid) {
		return followUpVisitsDao.deleteByPrimaryKey(cVisitsid);
	}

	@Override
	public int insert(FollowUpVisits record) {
		return followUpVisitsDao.insert(record);
	}

	@Override
	public int insertSelective(FollowUpVisits record) {
		return followUpVisitsDao.insertSelective(record);
	}

	@Override
	public FollowUpVisits selectByPrimaryKey(Integer cVisitsid) {
		return followUpVisitsDao.selectByPrimaryKey(cVisitsid);
	}

	@Override
	public int updateByPrimaryKeySelective(FollowUpVisits record) {
		return followUpVisitsDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FollowUpVisits record) {
		return followUpVisitsDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(FollowUpVisits record) {
		return followUpVisitsDao.saveOrUpdate(record);
	}

	@Override
	public List<FollowUpVisits> selectByPage(FollowUpVisits record) {
		return followUpVisitsDao.selectByPage(record);
	}

	@Override
	public int selectByPageCount(FollowUpVisits record) {
		return followUpVisitsDao.selectByPageCount(record);
	}
	
	
}
