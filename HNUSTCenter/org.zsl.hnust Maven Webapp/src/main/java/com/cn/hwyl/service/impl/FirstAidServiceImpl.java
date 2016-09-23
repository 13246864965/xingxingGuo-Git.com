package com.cn.hwyl.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hwyl.dao.IDeviceUpdateDao;
import com.cn.hwyl.dao.IFirstAidDao;
import com.cn.hwyl.dao.IFirstAidInfoDao;
import com.cn.hwyl.dao.IPatientsDao;
import com.cn.hwyl.main.CommonUtil;
import com.cn.hwyl.main.HWYLWebService;
import com.cn.hwyl.main.WSDLProperties;
import com.cn.hwyl.module.FirstAidCenterModule;
import com.cn.hwyl.pojo.FirstAid;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFirstAidService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Transactional(rollbackFor = {RuntimeException.class})
@Service("firstAidService")
public class FirstAidServiceImpl implements IFirstAidService{
	private  Logger logger = Logger.getLogger(FirstAidServiceImpl.class);
	@Resource
	private IFirstAidDao firstAidDao;

	@Resource
	private IFirstAidInfoDao firstAidDaoInfo;
	@Resource 
	private IPatientsDao patientsDao;
	@Resource
	private IDeviceUpdateDao deviceUpdateDao;
	
	@Override
	public int deleteByPrimaryKey(String cFirstaidid) {
		return firstAidDao.deleteByPrimaryKey(cFirstaidid);
	}

	@Override
	public int insert(FirstAid record) {
		return firstAidDao.insert(record);
	}

	@Override
	public int insertSelective(FirstAid record) {
		return firstAidDao.insertSelective(record);
	}

	@Override
	public FirstAid selectByPrimaryKey(String cFirstaidid) {
		return firstAidDao.selectByPrimaryKey(cFirstaidid);
	}

	@Override
	public int updateByPrimaryKeySelective(FirstAid record) {
		return firstAidDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FirstAid record) {
		return firstAidDao.updateByPrimaryKey(record);
	}

	@Override
	public FirstAid selectFirstAidIdByCondition(FirstAid record) {
		return firstAidDao.selectFirstAidIdByCondition(record);
	}

	@Override
	public int saveOrUpdate(FirstAid record) {
			return firstAidDao.saveOrUpdate(record);
	}

	@Override
	public Result saveOrUpdateBody(HeadRequest head, BodyRequest body) {
		Result result = new Result();
		Gson gson = new Gson();

		try {
			// 1,判断急救信息对象是否为空
			if (body.getFirstAidEditBody().getFirstAid() != null) {
				logger.info("FirstAid_Edit-- FirstAid param{} :" + body.getFirstAidEditBody().getFirstAid().toString());
				firstAidDao.saveOrUpdate(body.getFirstAidEditBody().getFirstAid());
			}
			// 2,判断急救详细信息对象是否为空
			if (body.getFirstAidEditBody().getFirstAidInfo() != null) {
				logger.info("FirstAid_Edit-- FirstAidInfo param{} :"
						+ body.getFirstAidEditBody().getFirstAidInfo().toString());
				firstAidDaoInfo.saveOrUpdate(body.getFirstAidEditBody().getFirstAidInfo());
			}

			// 4,添加设备合同记录表
			if (body.getFirstAidEditBody().getDeviceUpdate() != null) {
				logger.info("FirstAid_Edit-- DeviceUpdate param{} :"
						+ body.getFirstAidEditBody().getDeviceUpdate().toString());
				deviceUpdateDao.saveOrUpdate(body.getFirstAidEditBody().getDeviceUpdate());
			}

			// 3,判断患者信息对象是否为空
			if (body.getFirstAidEditBody().getPatients() != null) {
				logger.info("FirstAid_Edit-- Patients param{} :" + body.getFirstAidEditBody().getPatients().toString());
				// 3.1修改患者信息的时候先同步到云端
				head.setService("UpdateW ardUserInfo");
				String resultyun = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
						"dataService", gson.toJson(head), gson.toJson(
								CommonUtil.getWardshipViewObjectByPatients(body.getFirstAidEditBody().getPatients())));
				result = gson.fromJson(resultyun, new TypeToken<Result>() {
				}.getType());
				// "0"同步远程失败
				if ("0".equals(result.getResultCode())) {
					logger.error("同步患者信息到云平台程序异常!!" + result.getErrorInfo());
					result.setResultCode("0");
					result.setErrorInfo("前置端同步患者信息到云平台失败!!");
					return result;
				}
				// 3.2修改前置端患者信息
				patientsDao.saveOrUpdate(body.getFirstAidEditBody().getPatients());
			}

		} catch (Exception e) {
			logger.error("程序异常:" + e);
			throw new RuntimeException(e);
		}
		return result;
	}

}
