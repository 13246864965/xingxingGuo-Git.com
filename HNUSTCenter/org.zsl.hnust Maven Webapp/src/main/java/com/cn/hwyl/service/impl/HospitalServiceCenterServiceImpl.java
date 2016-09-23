package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IChannelDao;
import com.cn.hwyl.dao.IHospitalServiceCenterDao;
import com.cn.hwyl.dao.IOrganizationDao;
import com.cn.hwyl.module.SynchronousCenterCenterModule;
import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IHospitalServiceCenterService;
import com.google.gson.Gson;

@Transactional(rollbackFor = {RuntimeException.class})
@Service("hospitalServiceCenterService")
public class HospitalServiceCenterServiceImpl implements IHospitalServiceCenterService{

	private static Logger logger = Logger.getLogger(HospitalServiceCenterServiceImpl.class);
	@Resource
	private IHospitalServiceCenterDao hospitalServiceCenterDao;
	
	@Resource
	private IChannelDao channelDao;
	
	@Resource
	private IOrganizationDao organizationDao;
	
	@Override
	public int deleteByPrimaryKey(String cServicecentercode) {
		return hospitalServiceCenterDao.deleteByPrimaryKey(cServicecentercode);
	}

	@Override
	public int insert(HospitalServiceCenter record) {
		return hospitalServiceCenterDao.insert(record);
	}

	@Override
	public int insertSelective(HospitalServiceCenter record) {
		return hospitalServiceCenterDao.insertSelective(record);
	}

	@Override
	public HospitalServiceCenter selectByPrimaryKey(String cServicecentercode) {
		return hospitalServiceCenterDao.selectByPrimaryKey(cServicecentercode);
	}

	@Override
	public int updateByPrimaryKeySelective(HospitalServiceCenter record) {
		return hospitalServiceCenterDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HospitalServiceCenter record) {
		return hospitalServiceCenterDao.updateByPrimaryKey(record);
	}

	@Override
	public int saveOrUpdate(HospitalServiceCenter record) {
		return hospitalServiceCenterDao.saveOrUpdate(record);
	}

	@Override
	public Result saveOrUpdateBody(HeadRequest head, HospitalServiceCenter hospitalServiceCenter) {

		Result result = new Result();
		Channel channel = (Channel) hospitalServiceCenter;

		Organization organization = (Organization) hospitalServiceCenter;
		try {
			if (hospitalServiceCenter == null) {
				result.setResultCode("0");
				result.setErrorInfo("服务中心信息传参为空");
				return result;
			} else {
				hospitalServiceCenterDao.saveOrUpdate(hospitalServiceCenter);
				logger.info("中心端同步组织 创建hospitalServiceCenter successful ！！");
			}

			if (channel == null) {
				result.setResultCode("0");
				result.setErrorInfo("渠道信息传参为空");
				return result;
			} else {
				channelDao.saveOrUpdate(channel);
				logger.info("中心端同步组织 创建channel successful ！！");
			}

			if (organization == null) {
				result.setResultCode("0");
				result.setErrorInfo("机构信息传参为空");
				return result;
			} else {
				organizationDao.saveOrUpdate(organization);
				logger.info("中心端同步组织 创建organization successful ！！");
			}

			result.setResultCode("1");
			result.setErrorInfo("操作成功");
			return result;
		} catch (Exception e) {
			result.setErrorCode("0");
			result.setErrorInfo("保存组织信息到中心端失败");
			throw new RuntimeException(e);

		}

	}

}
