package com.cn.hwyl.module;

import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.Channel;
import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.Organization;
import com.cn.hwyl.pojo.Role;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IChannelService;
import com.cn.hwyl.service.IDeviceUpdateService;
import com.cn.hwyl.service.IHospitalServiceCenterService;
import com.cn.hwyl.service.IOrganizationService;
import com.cn.hwyl.service.IRoleService;
import com.cn.hwyl.service.IUserRoleService;
import com.cn.hwyl.service.IUserService;
import com.google.gson.Gson;

public class SynchronousModule {
	private  Logger logger = Logger.getLogger(SynchronousModule.class);

	public String synchronousOrganize(HeadRequest head, HospitalServiceCenter hospitalServiceCenter) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		
		IChannelService channelService = null;
		IHospitalServiceCenterService hospitalServiceCenterService = null;
		IOrganizationService organizationService = null;
		Gson gson = new Gson();

		Result result = new Result();

		Channel channel = (Channel) hospitalServiceCenter;

		Organization organization = (Organization) hospitalServiceCenter;

		// 同步添加/更新组织数据
		if ("synchronousDataByOrganize".equals(head.getService())) {
			int hospitalServiceCenterResult = 0;
			int channelResult = 0;
			int organizationResult = 0;

			try {
				hospitalServiceCenterService = (IHospitalServiceCenterService) ac
						.getBean("hospitalServiceCenterService");
				channelService = (IChannelService) ac.getBean("channelService");
				organizationService = (IOrganizationService) ac.getBean("organizationService");

				if (hospitalServiceCenter == null) {
					result.setResultCode("0");
					result.setErrorInfo("服务中心信息传参为空");
					return gson.toJson(result);
				} else {
					hospitalServiceCenterResult = hospitalServiceCenterService.saveOrUpdate(hospitalServiceCenter);
				}

				if (channel == null) {
					result.setResultCode("0");
					result.setErrorInfo("渠道信息传参为空");
					return gson.toJson(result);
				} else {
					channelResult = channelService.saveOrUpdate(channel);
				}

				if (organization == null) {
					result.setResultCode("0");
					result.setErrorInfo("机构信息传参为空");
					return gson.toJson(result);
				} else {
					organizationResult = organizationService.saveOrUpdate(organization);
				}

				if (hospitalServiceCenterResult > 0 && channelResult > 0 && organizationResult > 0) {
					result.setResultCode("1");
					result.setErrorInfo("操作成功");
					return gson.toJson(result);
				}

			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}
		}
	
		return gson.toJson(result);
	}

	public String synchronousWardshipID(HeadRequest head, DeviceUpdate deviceUpdate) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IDeviceUpdateService deviceUpdateService = null;
		Gson gson = new Gson();

		Result result = new Result();

		// 更换设备
		if ("synchronousDataByWardshipID".equals(head.getService())) {
			deviceUpdateService = (IDeviceUpdateService) ac.getBean("deviceUpdateService");
			try {
				deviceUpdateService.updateByPrimaryKey(deviceUpdate);
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setIsLogin(false);
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}

		}
		return gson.toJson(result);
	}
	
	public String synchronousDataByUser(HeadRequest head, BodyRequest bodyRequest) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		IUserService userService = (IUserService) ac.getBean("userService");
		IUserRoleService userRoleService = (IUserRoleService) ac.getBean("userRoleService");
		Gson gson = new Gson();
		Result result = new Result();
		int resultOk = 0;
		// 用户同步
		try {
			if ("synchronousDataByUserEdit".equals(head.getService())) {

				logger.info("front dataService synchronousDataByUser  param{} is:::"
						+ bodyRequest.getUserEditBody().getUser().toString());
				resultOk = userService.saveOrUpdate(bodyRequest.getUserEditBody().getUser());
				if(bodyRequest.getUserEditBody().getUserRole() !=null){
					userRoleService.insert(bodyRequest.getUserEditBody().getUserRole());
				}
			}
			if ("synchronousDataByUserDelete".equals(head.getService())) {

				logger.info("front dataService synchronousDataByUser  param{} is:::"
						+ bodyRequest.getUserDeleteBody().getcUserid().toString());
				resultOk = userService.deleteByPrimaryKey(bodyRequest.getUserDeleteBody().getcUserid());
			}
			if (resultOk > 0) {
				result.setResultCode("1");
				result.setErrorInfo("前置端同步中心端操作成功");
			}
		} catch (Exception e) {
			logger.error("程序异常:" + e);
			result.setResultCode("0");
			result.setErrorInfo("程序异常,请联系管理员！！");
			return gson.toJson(result);
		}

		return gson.toJson(result);
	}
	
	public String synchronousAdminRoleAndOrganize(HeadRequest head,Map<String,Object> bodyRequest) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IRoleService roleService = (IRoleService) ac.getBean("roleService");

		Gson gson = new Gson();
		Result result = new Result();
		
		try {
			logger.info("synchronousAdminRole param{} :" + bodyRequest.toString());
			//创建管理员角色,同步机构信息
			result = roleService.inserRoleAndOrganize(bodyRequest);
			
			result.setResultCode("1");
			result.setErrorInfo("同步机构创建前置端管理员成功");
		} catch (Exception e) {
			logger.error("程序异常:" + e);
			result.setResultCode("0");
			result.setErrorInfo("程序异常,请联系管理员！！");
			return gson.toJson(result);
		}
		
		return gson.toJson(result);
	}
	
}
