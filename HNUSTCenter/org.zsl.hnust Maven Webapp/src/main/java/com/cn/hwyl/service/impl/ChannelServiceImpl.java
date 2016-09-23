package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IChannelDao;
import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.service.IChannelService;


@Service("channelService")
public class ChannelServiceImpl implements IChannelService{

	
	@Resource
	private IChannelDao channelDao;
	
	@Override
	public int deleteByPrimaryKey(String cChannelcode) {
		return channelDao.deleteByPrimaryKey(cChannelcode);
	}

	@Override
	public int insert(Channel record) {
		return channelDao.insert(record);
	}

	@Override
	public int insertSelective(Channel record) {
		return channelDao.insertSelective(record);
	}

	@Override
	public Channel selectByPrimaryKey(String cChannelcode) {
		return channelDao.selectByPrimaryKey(cChannelcode);
	}

	@Override
	public int updateByPrimaryKeySelective(Channel record) {
		return channelDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Channel record) {
		return channelDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(Channel record) {
		return channelDao.saveOrUpdate(record);
	}

}
