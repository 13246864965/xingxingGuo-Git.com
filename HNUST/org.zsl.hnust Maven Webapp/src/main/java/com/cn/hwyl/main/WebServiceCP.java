package com.cn.hwyl.main;
import javax.jws.soap.SOAPBinding.Style;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.module.AmbulanceDeviceModule;
import com.cn.hwyl.module.FileInfoModule;
import com.cn.hwyl.module.FirstAidModule;
import com.cn.hwyl.module.FirstAidTaskModule;
import com.cn.hwyl.module.FollowUpVisitsModule;
import com.cn.hwyl.module.OrganizeModule;
import com.cn.hwyl.module.PermissionsModule;
import com.cn.hwyl.module.SynchronousModule;
import com.cn.hwyl.module.ThrombolysisSurveyModule;
import com.cn.hwyl.module.UserModule;
import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.FrontConfiguration;
import com.cn.hwyl.pojo.HospitalServiceCenter;
import com.cn.hwyl.pojo.body.UploadThreadBody;
import com.cn.hwyl.pojo.entity.SendMessage;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IFrontConfigurationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 此类为端点服务类，它的方法publish用于将一个已经添加了@WebService注解对象绑定到一个地址的端口上。
 * 
 * @WebService
 * 它是一个注解，用在类上指定将此类发布成一个ws. Endpoint
 */
@WebService
@SOAPBinding(style = Style.RPC) 
public class WebServiceCP{
	
	private static Logger logger = Logger.getLogger(WebServiceCP.class);

	private String result = null;
	// exclude=true时，该方法不会被发布@WebMethod(exclude = false)
	public String callService(@WebParam(name="head")String head, @WebParam(name="body")String body) {
		logger.info("callService HeadRequest param{0} is:::" + head.toString());
		logger.info("callService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		HeadRequest headReq = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());

		BodyRequest bodyReq = gson.fromJson(body, new TypeToken<BodyRequest>() {
		}.getType());

		
		String service = headReq.getService();
		// 用户模块
		if (service.contains("User_")) {
			result = new UserModule().userAll(headReq, bodyReq);
		}
		// 急救模块
		if (service.contains("FirstAid_")) {
			result = new FirstAidModule().firstAidAll(headReq, bodyReq);
		}
		// 机构模块
		if (service.contains("Organize_")) {
			result = new OrganizeModule().organizeAll(headReq, bodyReq);
		}
		// 权限模块
		if (service.contains("Permissions_")) {
			result = new PermissionsModule().permissionsAll(headReq, bodyReq);
		}
		//设备模块
		if(service.contains("AmbulanceDevice_")){
			result = new AmbulanceDeviceModule().ambulanceDeviceAll(headReq, bodyReq);
		}
		//文件模块
		if(service.contains("FileInfo_")){
			result = new FileInfoModule().fileInfoAll(headReq, bodyReq);
		}
		//溶栓核查
		if(service.contains("ThrombolysisSurvey_")){
			result  = new ThrombolysisSurveyModule().thrombolysisSurveyAll(headReq, bodyReq);
		}
		//患者随访
		if(service.contains("FollowUpVisits_")){
			result = new FollowUpVisitsModule().followUpVisitsAll(headReq, bodyReq);
		}
		//急救任务
		if(service.contains("FirstaidTask_")){
			result = new FirstAidTaskModule().firstAidTaskAll(headReq, bodyReq);
		}
		
		return result;
	}
	
	@WebMethod
	public String getFrontService(@WebParam(name = "head", targetNamespace = "http://main.hwyl.cn.com/") String head,
			@WebParam(name = "body", targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("getFrontService HeadRequest param{0} is:::" + head.toString());
		logger.info("getFrontService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		Result result = new Result();
		// String str = "http://"+uploadUrl+":8080/HWYL/file/upload";
		try {
			HeadRequest headReq = gson.fromJson(head, new TypeToken<HeadRequest>() {
			}.getType());
			if ("FrontConfiguration".equals(headReq.getService())) {
				// 调用中心端获取服务器配置信息
				String getFrontConfigFromCneter = HWYLWebService.getWSDL(WSDLProperties.getCenterWsdl(),
						WSDLProperties.getCenterNameSpace(), "provideFrontService", head, body);

				result = gson.fromJson(getFrontConfigFromCneter, new TypeToken<Result>() {
				}.getType());
				if ("0".equals(result.getResultCode())) {
					return getFrontConfigFromCneter;
				}
				// 0:获取上传路径地址，1获取服务器配置信息
				result.setObj(result.getObj());
				result.setResultCode("1");
			}
		} catch (Exception e) {
			logger.error("程序异常:" + e);
			result.setResultCode("0");
			result.setErrorInfo("程序异常,请联系管理员！！");
			return gson.toJson(result);
		}
		return gson.toJson(result);

	}
	
	/**
	 * 提供远程同步数据入口
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String dataService(@WebParam(name = "head",targetNamespace = "http://main.hwyl.cn.com/") String head, @WebParam(name = "body",targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("callService HeadRequest param{0} is:::" + head.toString());
		logger.info("callService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();
		

		HeadRequest q = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());
		//提供云端同步组织接口
		if ("synchronousDataByOrganize".equals(q.getService())) {
			HospitalServiceCenter hospitalServiceCenter = gson.fromJson(body, new TypeToken<HospitalServiceCenter>() {
			}.getType());

			logger.info("front dataService synchronousDataByOrganize param{} is:::" + hospitalServiceCenter.toString());
			result = new SynchronousModule().synchronousOrganize(q, hospitalServiceCenter);
		}
		if ("synchronousDataByWardshipID".equals(q.getService())) {
			DeviceUpdate deviceUpdate = gson.fromJson(body, new TypeToken<DeviceUpdate>() {
			}.getType());
			
			logger.info("front dataService synchronousDataByWardshipID param{} is:::" + deviceUpdate.toString());
			result = new SynchronousModule().synchronousWardshipID(q, deviceUpdate);
		}
		
		//提供远程同步用户接口
		if (q.getService().contains("synchronousDataByUser")) {
			BodyRequest bodyRequest = gson.fromJson(body, new TypeToken<BodyRequest>() {
			}.getType());

			result = new SynchronousModule().synchronousDataByUser(q, bodyRequest);
		}
		
		//提供中心端创建管理员角色
		if("createAdminRoleAndSynchronousFront".equals(q.getService())){
//			HospitalServiceCenter bodyRequest = gson.fromJson(body, new TypeToken<HospitalServiceCenter>() {
//			}.getType());
			Map<String,Object> map = new Gson().fromJson(body, new TypeToken<Map<String,Object>>() {
			}.getType());
			
			result = new SynchronousModule().synchronousAdminRoleAndOrganize(q, map);
		}
		return result;
	}
	
	/**
	 * 调用远程服务接口
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String wsdlService(@WebParam(name = "head",targetNamespace = "http://main.hwyl.cn.com/") String head, @WebParam(name = "body",targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("wsdlService HeadRequest param{0} is:::" + head.toString());
		logger.info("wsdlService BodyRequest param{1} is:::" + body.toString());

		Gson gson = new Gson();

		HeadRequest q = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());

		// 调用中心端 根据组织ID查询 服务信息接口(上传)
		if ("FrontConfiguration".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getCenterWsdl(), WSDLProperties.getCenterNameSpace(),
					"getFrontService", head, body);
		}
		// 调用云端服务判断设备是否发放并且返回已发放设备的合同 号
		if ("GetEqmtUseStatus".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		// 根据设备号、合同号等各种查询条件获取所需的合同
		if ("GetWardship".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		// 根据合同号获取心电图传输时间接口
		if ("GetFirstHECGInfo".equals(q.getService())) {
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		//设备归还接口,归还所需急救合同
		if("RetAidWardship".equals(q.getService())){
			result = HWYLWebService.getWSDL(WSDLProperties.getYunWsdl(), WSDLProperties.getYunNameSpace(),
					"callService", head, body);
		}
		return result;
	}
	/**
	 * 		返回心电图信息
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public byte[] getDataStrByWardshipId(@WebParam(name = "head",targetNamespace = "http://main.hwyl.cn.com/") String head, @WebParam(name = "body",targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("getDataStrByWardshipId HeadRequest param{0} is:::" + head.toString());
		logger.info("getDataStrByWardshipId BodyRequest param{1} is:::" + body.toString());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeadRequest q = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());
		String resultByte = new String();
		// 返回心电图信息
		if ("UploadThread".equals(q.getService())) {
			UploadThreadBody b = gson.fromJson(body, new TypeToken<UploadThreadBody>() {
			}.getType());
			UploadThread uploadThread = new UploadThread(b.getWardshipId(), b.getKey(), b.getPtime());
			resultByte = uploadThread.run();
			return resultByte.getBytes();
		}
		return resultByte.getBytes();
	}
	/**
	 * 发送消息
	 * @param head
	 * @param body
	 * @return
	 */
	@WebMethod
	public String sendMessage(@WebParam(name = "head",targetNamespace = "http://main.hwyl.cn.com/") String head, @WebParam(name = "body",targetNamespace = "http://main.hwyl.cn.com/") String body) {
		logger.info("sendMessage HeadRequest param{0} is:::" + head.toString());
		logger.info("sendMessage BodyRequest param{1} is:::" + body.toString());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		HeadRequest q = gson.fromJson(head, new TypeToken<HeadRequest>() {
		}.getType());
		SendMessage message = gson.fromJson(body, new TypeToken<SendMessage>() {
		}.getType());
		String result = null;
		if ("sendMessage".equals(q.getService())) {
			try {
				result = SendMessageMain.sendToPhone(message);
			} catch (Exception e) {
				logger.error("sendMessage faild!!" + e);
			}
		}
		return result;
	}
	
	
	@WebMethod
	public String test(){
		return "ok";
	}
	@WebMethod
	public String test1(@WebParam(name = "data") String data){
		System.out.println("test1===========："+data);
		return "ok:" + data;
	}
	
}
