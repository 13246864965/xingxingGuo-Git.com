package com.cn.hwyl.main;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.module.AmbulanceDeviceCenterModule;
import com.cn.hwyl.module.ConfigurationCenterModule;
import com.cn.hwyl.module.FileInfoCenterModule;
import com.cn.hwyl.module.FirstAidCenterModule;
import com.cn.hwyl.module.OrganizeCenterModule;
import com.cn.hwyl.module.PermissionsCenterModule;
import com.cn.hwyl.module.SynchronousCenterCenterModule;
import com.cn.hwyl.module.UserCenterModule;
import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 此类为端点服务类，它的方法publish用于将一个已经添加了@WebService注解对象绑定到一个地址的端口上。
 * 
 * @WebService
 * 它是一个注解，用在类上指定将此类发布成一个 exclude=true时，该方法不会被发布@WebMethod(exclude = false)
 *
 *胸痛平台中心端提供接口
 */
@WebService
@SOAPBinding(style = Style.RPC) 
public class WebCenterServiceCP{
	
	private static Logger logger = Logger.getLogger(WebCenterServiceCP.class);

	/**
	 * 中心端提供业务接口
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String callService(@WebParam(name="head",targetNamespace = "http://main.hwyl.cn.com/")String head, @WebParam(name="body",targetNamespace = "http://main.hwyl.cn.com/")String body) {
		logger.info("callService HeadRequest param{0} is:::" + head.toString());
		logger.info("callService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		HeadRequest headReq = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());

		BodyRequest bodyReq = gson.fromJson(body, new TypeToken<BodyRequest>() {
		}.getType());

		String result = null;
		String service = headReq.getService();
		// 用户模块
		if (service.contains("User_")) {
			result = UserCenterModule.userAll(headReq, bodyReq);
		}
		// 急救模块
		if (service.contains("FirstAid_")) {
			result = new FirstAidCenterModule().firstAidAll(headReq, bodyReq);
		}
		// 机构模块
		if (service.contains("Organize_")) {
			result = OrganizeCenterModule.organizeAll(headReq, bodyReq);
		}
		// 权限模块
		if (service.contains("Permissions_")) {
			result = PermissionsCenterModule.permissionsAll(headReq, bodyReq);
		}
		//设备模块
		if(service.contains("AmbulanceDevice_")){
			result = AmbulanceDeviceCenterModule.ambulanceDeviceAll(headReq, bodyReq);
		}
		//文件模块
		if(service.contains("FileInfo_")){
			result = FileInfoCenterModule.fileInfoAll(headReq, bodyReq);
		}
		if(service.contains("Configuration")){
			result  = ConfigurationCenterModule.configurationAll(headReq, bodyReq);
		}
		
		return result;
	}
	/**
	 * 中心端提供 根据组织ID查询前置端服务信息
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String provideFrontService(
			@WebParam(name = "head", targetNamespace = "http://main.hwyl.cn.com/") String head,
			@WebParam(name = "body", targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("provideFrontService HeadRequest param{0} is:::" + head.toString());
		logger.info("provideFrontService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		Result result = new Result();
		BodyRequest bodyReq = gson.fromJson(body, new TypeToken<BodyRequest>() {
		}.getType());

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IFrontConfigurationService frontConfigurationService = (IFrontConfigurationService) ac
				.getBean("frontConfigurationService");
		FrontConfiguration frontConfiguration = null;
		try {
			frontConfiguration = frontConfigurationService.selectByPrimaryKey(bodyReq.getcOrgId().split(",")[0]);
			if (frontConfiguration == null) {
				result.setErrorCode("0");
				result.setErrorInfo("组织ID:" + bodyReq.getcOrgId() + "服务器配置信息不存在！！");
				return gson.toJson(result);
			}
			if ("0".equals(bodyReq.getcOrgId().split(",")[1])) {
				result.setObj("http://" + frontConfiguration.getcServeraddress() + "/HWYL/file/upload");
			} else {
				result.setObj(frontConfiguration);
			}
			result.setResultCode("1");
		} catch (Exception e) {
			logger.error("程序异常:" + e);
			result.setResultCode("0");
			result.setErrorInfo("程序异常,请联系管理员！！");

		}
		return gson.toJson(result);

	}
	/**
	 * 中心端提供接口 供云平台,前置端同步数据
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String dataService(@WebParam(name = "head", targetNamespace = "http://main.hwyl.cn.com/") String head,
			@WebParam(name = "body", targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("center dataService HeadRequest param{0} is:::" + head.toString());
		logger.info("center dataService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		String result = null;

		HeadRequest q = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());
		//提供云端同步组织
		if ("synchronousDataByOrganize".equals(q.getService())) {
			HospitalServiceCenter hospitalServiceCenter = gson.fromJson(body, new TypeToken<HospitalServiceCenter>() {
			}.getType());
			logger.info("center dataService  param{} is:::" + hospitalServiceCenter.toString());
			//同步组织之前先创建管理员角色
			result = SynchronousCenterCenterModule.synchronousOrganize(q, hospitalServiceCenter);
		}
		if ("synchronousDataByWardshipID".equals(q.getService())) {
			DeviceUpdate deviceUpdate = gson.fromJson(body, new TypeToken<DeviceUpdate>() {
			}.getType());

			logger.info("center dataService  param{} is:::" + deviceUpdate.toString());
			result = SynchronousCenterCenterModule.synchronousWardshipID(q, deviceUpdate);
		}
		// 提供 前置端同步用户数据
		if (q.getService().contains("synchronousDataByUser")) {
			BodyRequest bodyRequest = gson.fromJson(body, new TypeToken<BodyRequest>() {
			}.getType());

			result = SynchronousCenterCenterModule.synchronousDataByUser(q, bodyRequest);
		}
//		//提供前置端获取服务器配置信息接口
//		if (q.getService().contains("provideFrontconfiguration")) {
//			BodyRequest bodyRequest = gson.fromJson(body, new TypeToken<BodyRequest>() {
//			}.getType());
//			result = SynchronousCenterCenterModule.provideFrontconfiguration(q, bodyRequest);
//		}
		return result;
	}
	/**
	 * 中心端 调用云平台服务接口
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String wsdlService(@WebParam(name = "head",targetNamespace = "http://main.hwyl.cn.com/") String head, @WebParam(name = "body",targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("wsdlService HeadRequest param{0} is:::" + head.toString());
		logger.info("wsdlService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		String result = null;

		HeadRequest q = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());
		
		// 调用云端服务判断设备是否发放并且返回已发放设备的合同 号
		if ("GetEqmtUseStatus".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		//根据wardship获取m3设备上的患者信息
		if ("GetWardship".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		// 根据合同号获取心电图传输时间接口
		if ("GetFirstHECGInfo".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		
		return result;
	}
	
	@WebMethod
	public String test(){
		return "ok";
	}
	@WebMethod
	public String test1(@WebParam(name = "data",targetNamespace = "http://main.hwyl.cn.com/") String data){
		System.out.println("test1===========："+data);
		return "ok:" + data;
	}
	
}
