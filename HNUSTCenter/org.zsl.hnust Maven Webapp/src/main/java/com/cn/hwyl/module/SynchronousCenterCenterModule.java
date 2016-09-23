package com.cn.hwyl.module;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IDeviceUpdateService;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.cn.hwyl.service.IHospitalServiceCenterService;
import com.cn.hwyl.service.IUserRoleService;
import com.cn.hwyl.service.IUserService;
import com.google.gson.Gson;

public class SynchronousCenterCenterModule {

	private static Logger logger = Logger.getLogger(SynchronousCenterCenterModule.class);

	@SuppressWarnings("resource")
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

	public static String synchronousOrganize(HeadRequest head, HospitalServiceCenter hospitalServiceCenter) {

		// IOrganizationService organizationService = null;
		IHospitalServiceCenterService hospitalServiceCenterService = null;

		Gson gson = new Gson();

		Result result = new Result();

		// Organization organization = (Organization) hospitalServiceCenter;

		// 同步添加/更新组织数据
		if ("synchronousDataByOrganize".equals(head.getService())) {
			try {
				hospitalServiceCenterService = (IHospitalServiceCenterService) ac
						.getBean("hospitalServiceCenterService");
				// organizationService = (IOrganizationService)
				// ac.getBean("organizationService");
				/**
				 * 同步机构时：1,添加一个管理员角色;2同步到对应的前置端
				 */
				// 1,判断是否已同步过
				// Organization isOrganization =
				// organizationService.selectByPrimaryKey(organization.getOrgId());
				// if (isOrganization == null || "".equals(isOrganization)) {
				// // 同步到前置端
				// createAdminRoleAndSynchronousFront(head,
				// hospitalServiceCenter);
				// }
				// 中心端数据入库
				logger.info("中心端同步组织begin ！！！");
				result = hospitalServiceCenterService.saveOrUpdateBody(head, hospitalServiceCenter);
				logger.info("中心端同步组织successFul ！！！");
				if ("1".equals(result.getResultCode())) {
					result.setResultCode("1");
					result.setErrorInfo("操作成功");
				}
			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}
		}

		return gson.toJson(result);
	}

	public static String synchronousWardshipID(HeadRequest head, DeviceUpdate deviceUpdate) {
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

	public static String synchronousDataByUser(HeadRequest head, BodyRequest bodyRequest) {

		IUserService userService = (IUserService) ac.getBean("userService");
		IUserRoleService userRoleService = (IUserRoleService) ac.getBean("userRoleService");
		Gson gson = new Gson();
		Result result = new Result();
		int resultOk = 0;
		// 用户同步
		try {
			if ("synchronousDataByUserEdit".equals(head.getService())) {
				logger.info("center front dataService synchronousDataByUserEdit  param{} is:::"
						+ bodyRequest.getUserEditBody().getUser().toString());
				resultOk = userService.saveOrUpdate(bodyRequest.getUserEditBody().getUser());
				if (bodyRequest.getUserEditBody().getUserRole() != null) {
					userRoleService.insert(bodyRequest.getUserEditBody().getUserRole());
				}
			}
			if ("synchronousDataByUserDelete".equals(head.getService())) {
				logger.info("center front dataService synchronousDataByUserEdit  param{} is:::"
						+ bodyRequest.getUserDeleteBody().getcUserid());
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

	// /**
	// * 同步机构时：1,添加一个管理员角色;2同步到对应的前置端
	// */
	// private static Result createAdminRoleAndSynchronousFront(HeadRequest
	// head,
	// HospitalServiceCenter hospitalServiceCenter) {
	//
	// Gson gson = new Gson();
	// Result result = new Result();
	// String resultFront = null;
	//
	// Role role = new Role();
	// String roleId = UUID.randomUUID().toString();
	// role.setcRoleid(roleId);
	// role.setcRolename("机构管理员");
	// role.setcRolecode("jggly");
	// role.setcRoletype(1);// 0：普通角色；1：管理员角色
	// role.setcSuatus("0");
	// role.setcOrgid(hospitalServiceCenter.getOrgId());
	// role.setcOrgcode(hospitalServiceCenter.getOrgCode());
	// role.setcUpdatedate(hospitalServiceCenter.getUpdateTime());
	// role.setcUpdateuserid(hospitalServiceCenter.getUpdateUserId());
	//
	// // 1,同步到前置端
	// IFrontConfigurationService frontConfigurationService =
	// (IFrontConfigurationService) ac
	// .getBean("frontConfigurationService");
	//
	// FrontConfiguration frontConfiguration = frontConfigurationService
	// .selectByPrimaryKey(hospitalServiceCenter.getOrgId());
	//
	// IRoleService roleService = (IRoleService) ac.getBean("roleService");
	//
	// if (frontConfiguration != null) {
	// // 2,中心端同步到对应的前置端
	// String wsdlUrl = "http://" + frontConfiguration.getcWsdladdress() +
	// "/api/services/CPManageWebservice";
	// String nameSpace = "http://main.hwyl.cn.com/";
	// String method = "dataService";
	// head.setService("createAdminRoleAndSynchronousFront");
	// hospitalServiceCenter.setRoleId(roleId);
	// resultFront = HWYLWebService.getWSDL(wsdlUrl, nameSpace, method,
	// gson.toJson(head), gson.toJson(hospitalServiceCenter));
	// }
	//
	// result = gson.fromJson(resultFront, new TypeToken<Result>() {
	// }.getType());
	//
	// // "0"同步远程失败
	// if ("0".equals(result.getResultCode())) {
	// logger.error("管理员角色同步前置端异常!!" + result.getErrorInfo());
	// result.setResultCode("0");
	// result.setErrorInfo("云端同步组织创建前置端管理员角色失败!!");
	// return result;
	// }
	// // 2,在中心端创建
	// int roleResult = roleService.insert(role);
	// if (roleResult > 0) {
	// result.setResultCode("1");
	// result.setErrorInfo("云端同步组织创建前置端管理员角色成功!!");
	// }
	// result.setResultCode("1");
	// logger.info("中心端同步数据到前置端：synchronousDataByOrganize
	// createAdminRoleAndSynchronousFront successful！！");
	//
	// return result;
	// }

}
