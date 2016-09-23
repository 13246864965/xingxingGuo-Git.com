package com.cn.hwyl.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cn.hwyl.dao.IChannelDao;
import com.cn.hwyl.dao.IHospitalServiceCenterDao;
import com.cn.hwyl.dao.IOrgConfigurationDao;
import com.cn.hwyl.dao.IOrganizationDao;
import com.cn.hwyl.dao.IRoleDao;
import com.cn.hwyl.main.HWYLWebService;
import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.OrgConfiguration;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IOrgConfigurationService;
import com.cn.hwyl.service.IRoleService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("orgConfigurationService")
public class OrgConfigurationServiceImpl implements IOrgConfigurationService {

	private static Logger logger = Logger.getLogger(OrgConfigurationServiceImpl.class);
	@Resource
	private IOrgConfigurationDao orgConfigurationDao;
	
	@Resource
	private IHospitalServiceCenterDao hospitalServiceCenterDao;
	
	@Resource
	private IChannelDao channelDao;
	
	@Resource
	private IOrganizationDao organizationDao;
	
	@Resource
	private IRoleDao roleDao;
	
	@Override
	public int deleteByPrimaryKey(String cConfigid) {
		return orgConfigurationDao.deleteByPrimaryKey(cConfigid);
	}

	@Override
	public int insert(OrgConfiguration record) {
		return orgConfigurationDao.insert(record);
	}

	@Override
	public int insertSelective(OrgConfiguration record) {
		return orgConfigurationDao.insertSelective(record);
	}

	@Override
	public OrgConfiguration selectByPrimaryKey(String cConfigid) {
		return orgConfigurationDao.selectByPrimaryKey(cConfigid);
	}

	@Override
	public int updateByPrimaryKeySelective(OrgConfiguration record) {
		return orgConfigurationDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrgConfiguration record) {
		return orgConfigurationDao.updateByPrimaryKey(record);
	}

	@Override
	public Result insertOrgAndsyncFranc(OrgConfiguration record) {
		//中心端插入服务器配置
		orgConfigurationDao.insert(record);
		OrgConfiguration oggConfiguration = orgConfigurationDao.selectByPrimaryKey(record.getcOrgid());
		
		//查询Organization
		Organization organization = organizationDao.selectByPrimaryKey(record.getcOrgid());
		//查询HospitalServiceCenter
		HospitalServiceCenter hospitalServiceCenter  = hospitalServiceCenterDao.selectByPrimaryKey(record.getcOrgid());
		//查询chanel
		Channel channel  = channelDao.selectByPrimaryKey(record.getcOrgid());
		
		return null;
	}

}
