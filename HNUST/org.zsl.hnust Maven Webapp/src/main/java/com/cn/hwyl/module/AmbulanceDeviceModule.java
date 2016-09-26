package com.cn.hwyl.module;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.hwyl.pojo.AmbulanceDevice;
import com.cn.hwyl.pojo.DeviceUpdate;
import com.cn.hwyl.pojo.request.BodyRequest;
import com.cn.hwyl.pojo.request.HeadRequest;
import com.cn.hwyl.pojo.response.Result;
import com.cn.hwyl.service.IAmbulanceDeviceService;
import com.cn.hwyl.service.IDeviceUpdateService;
import com.google.gson.Gson;

public class AmbulanceDeviceModule {
	private  Logger logger = Logger.getLogger(FirstAidModule.class);

	public  String ambulanceDeviceAll(HeadRequest head, BodyRequest body) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");

		IAmbulanceDeviceService ambulanceDeviceService = (IAmbulanceDeviceService) ac.getBean("ambulanceDeviceService");
		IDeviceUpdateService deviceUpdateService = (IDeviceUpdateService) ac.getBean("deviceUpdateService");
		Result result = new Result();

		Gson gson = new Gson();

		// 设备查询（orgID,设备编号）
		if ("AmbulanceDevice_Select".equals(head.getService())) {
			if (body.getAmbulanceDeviceSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			List<AmbulanceDevice> ambulanceDevicelists = null;
			int count = 0;
			try {
				logger.info("AmbulanceDevice_Select param{} :"
						+ body.getAmbulanceDeviceSelectBody().getAmbulanceDevice().toString());
				ambulanceDevicelists = ambulanceDeviceService
						.selectByPage(body.getAmbulanceDeviceSelectBody().getAmbulanceDevice());
				count = ambulanceDeviceService.selectByCount(body.getAmbulanceDeviceSelectBody().getAmbulanceDevice());

			} catch (Exception e) {
				logger.error("程序异常:" + e);
				result.setResultCode("0");
				result.setErrorInfo("程序异常,请联系管理员！！");
				return gson.toJson(result);
			}
			if (ambulanceDevicelists.size() > 0 && count > 0) {
				result.setResultCode("1");
				result.setObj(ambulanceDevicelists);
				result.setRecordNum(count);
				result.setPageNum((int) Math.ceil(
						(double) count / body.getAmbulanceDeviceSelectBody().getAmbulanceDevice().getRecordNumPer()));
			}

		}
		//更换设备
		if ("AmbulanceDevice_DeviceUpdate".equals(head.getService())) {
			if (body.getDeviceUpdateBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			if (body.getDeviceUpdateBody().getDeviceUpdate() != null) {
				try {
					logger.info("AmbulanceDevice_Update--  param{} :"
							+ body.getDeviceUpdateBody().getDeviceUpdate().toString());
					deviceUpdateService.updateByPrimaryKey(body.getDeviceUpdateBody().getDeviceUpdate());
				} catch (Exception e) {
					logger.error("程序异常:" + e);
					result.setResultCode("0");
					result.setErrorInfo("程序异常,请联系管理员！！");
				}
			}

		}
		 //根据急救编号查询第一条/最后一条设备合同信息
		if(head.getService().contains("AmbulanceDevice_DeviceUpdate_selectChoose_")){
			if (body.getDeviceUpdatSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			DeviceUpdate deviceUp = null;
			if (body.getDeviceUpdatSelectBody().getcFirstaidid() != null) {
				logger.info("AmbulanceDevice_DeviceUpdate_selectChoose_ param    :"+body.getDeviceUpdatSelectBody().getcFirstaidid().toString());
				try {
					// 查询最后一条
					if ("AmbulanceDevice_DeviceUpdate_selectChoose_last".equals(head.getService())) {
						deviceUp = deviceUpdateService
								.selectDeviceUpdateByLast(body.getDeviceUpdatSelectBody().getcFirstaidid());
					}
					// 第一条
					if ("AmbulanceDevice_DeviceUpdate_selectChoose_first".equals(head.getService())) {
						deviceUp = deviceUpdateService
								.selectDeviceUpdateByFirst(body.getDeviceUpdatSelectBody().getcFirstaidid());
					}
					result.setResultCode("1");
					result.setObj(deviceUp);
				} catch (Exception e) {
					logger.error("未查到设备信息"+body.getDeviceUpdatSelectBody().getcFirstaidid());
					result.setResultCode("0");
					result.setErrorInfo("未查到设备信息"+body.getDeviceUpdatSelectBody().getcFirstaidid());
					return gson.toJson(result);
				
				}
				return gson.toJson(result);
			}
		}
		//查询设备是否创建急救
		if("AmbulanceDevice_DeviceUpdate_select".equals(head.getService())){
			if (body.getDeviceUpdatSelectBody() == null) {
				result.setResultCode("0");
				result.setErrorInfo("传参为空");
				return gson.toJson(result);
			}
			if(body.getDeviceUpdatSelectBody().getcWardshipid() != null){
				DeviceUpdate deviceUpdate = null;
				try {
					logger.info("AmbulanceDevice_DeviceUpdate_select param:      "+body.getDeviceUpdatSelectBody().getcWardshipid().toString());
					deviceUpdate = deviceUpdateService.selectByPrimaryKey(body.getDeviceUpdatSelectBody().getcWardshipid());
				} catch (Exception e) {
					logger.error("程序异常:" + e);
					result.setResultCode("0");
					result.setErrorInfo("程序异常,请联系管理员！！");
				}
				if(deviceUpdate == null){
					logger.error("该设备未创建急救"+body.getDeviceUpdatSelectBody().getcWardshipid());
					result.setResultCode("1");
					result.setErrorCode("1");
					result.setErrorInfo("该设备未创建急救"+body.getDeviceUpdatSelectBody().getcWardshipid());
					return gson.toJson(result);
				}
				//表示设备已归还
				if (deviceUpdate.getcReturntime() != null) {
					result.setResultCode("1");
					result.setErrorCode("1");
					result.setErrorInfo("设备已归还,未创建");
				} else {
					result.setResultCode("1");
					result.setErrorCode("0");
					result.setErrorInfo("该设备已创建急救");
				}
				
			}
		}
		
		return gson.toJson(result);
	}
}
